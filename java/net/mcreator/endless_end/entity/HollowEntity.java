
package net.mcreator.endless_end.entity;

import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoEntity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.endless_end.procedures.HollowUpdateTickProcedure;
import net.mcreator.endless_end.procedures.HollowLeapTestProcedure;
import net.mcreator.endless_end.procedures.HollowDeathProcedure;
import net.mcreator.endless_end.procedures.HollowBurrowProcedure;
import net.mcreator.endless_end.procedures.BurrowConditionProcedure;

import javax.annotation.Nullable;

public class HollowEntity extends Monster implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(HollowEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(HollowEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(HollowEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_summoning_progress = SynchedEntityData.defineId(HollowEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_agitation = SynchedEntityData.defineId(HollowEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_burrow_progress = SynchedEntityData.defineId(HollowEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_heartbeat = SynchedEntityData.defineId(HollowEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_jump_cooldown = SynchedEntityData.defineId(HollowEntity.class, EntityDataSerializers.INT);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public HollowEntity(EntityType<HollowEntity> type, Level world) {
		super(type, world);
		xpReward = 10;
		setNoAi(false);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(SHOOT, false);
		builder.define(ANIMATION, "undefined");
		builder.define(TEXTURE, "hollow_texture");
		builder.define(DATA_summoning_progress, 0);
		builder.define(DATA_agitation, 0);
		builder.define(DATA_burrow_progress, 0);
		builder.define(DATA_heartbeat, 0);
		builder.define(DATA_jump_cooldown, 0);
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new LeapAtTargetGoal(this, (float) 0.5) {
			@Override
			public boolean canUse() {
				double x = HollowEntity.this.getX();
				double y = HollowEntity.this.getY();
				double z = HollowEntity.this.getZ();
				Entity entity = HollowEntity.this;
				Level world = HollowEntity.this.level();
				return super.canUse() && HollowLeapTestProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = HollowEntity.this.getX();
				double y = HollowEntity.this.getY();
				double z = HollowEntity.this.getZ();
				Entity entity = HollowEntity.this;
				Level world = HollowEntity.this.level();
				return super.canContinueToUse() && HollowLeapTestProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, false, false) {
			@Override
			public boolean canUse() {
				double x = HollowEntity.this.getX();
				double y = HollowEntity.this.getY();
				double z = HollowEntity.this.getZ();
				Entity entity = HollowEntity.this;
				Level world = HollowEntity.this.level();
				return super.canUse() && BurrowConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = HollowEntity.this.getX();
				double y = HollowEntity.this.getY();
				double z = HollowEntity.this.getZ();
				Entity entity = HollowEntity.this;
				Level world = HollowEntity.this.level();
				return super.canContinueToUse() && BurrowConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}

			@Override
			public boolean canUse() {
				double x = HollowEntity.this.getX();
				double y = HollowEntity.this.getY();
				double z = HollowEntity.this.getZ();
				Entity entity = HollowEntity.this;
				Level world = HollowEntity.this.level();
				return super.canUse() && BurrowConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = HollowEntity.this.getX();
				double y = HollowEntity.this.getY();
				double z = HollowEntity.this.getZ();
				Entity entity = HollowEntity.this;
				Level world = HollowEntity.this.level();
				return super.canContinueToUse() && BurrowConditionProcedure.execute(entity);
			}

		});
		this.targetSelector.addGoal(4, new HurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = HollowEntity.this.getX();
				double y = HollowEntity.this.getY();
				double z = HollowEntity.this.getZ();
				Entity entity = HollowEntity.this;
				Level world = HollowEntity.this.level();
				return super.canUse() && BurrowConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = HollowEntity.this.getX();
				double y = HollowEntity.this.getY();
				double z = HollowEntity.this.getZ();
				Entity entity = HollowEntity.this;
				Level world = HollowEntity.this.level();
				return super.canContinueToUse() && BurrowConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				double x = HollowEntity.this.getX();
				double y = HollowEntity.this.getY();
				double z = HollowEntity.this.getZ();
				Entity entity = HollowEntity.this;
				Level world = HollowEntity.this.level();
				return super.canUse() && BurrowConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = HollowEntity.this.getX();
				double y = HollowEntity.this.getY();
				double z = HollowEntity.this.getZ();
				Entity entity = HollowEntity.this;
				Level world = HollowEntity.this.level();
				return super.canContinueToUse() && BurrowConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(6, new FloatGoal(this) {
			@Override
			public boolean canUse() {
				double x = HollowEntity.this.getX();
				double y = HollowEntity.this.getY();
				double z = HollowEntity.this.getZ();
				Entity entity = HollowEntity.this;
				Level world = HollowEntity.this.level();
				return super.canUse() && BurrowConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = HollowEntity.this.getX();
				double y = HollowEntity.this.getY();
				double z = HollowEntity.this.getZ();
				Entity entity = HollowEntity.this;
				Level world = HollowEntity.this.level();
				return super.canContinueToUse() && BurrowConditionProcedure.execute(entity);
			}
		});
	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(Items.ECHO_SHARD));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:hollow.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:hollow.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("endless_end:hollow.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.is(DamageTypes.FALL))
			return false;
		if (source.is(DamageTypes.CACTUS))
			return false;
		if (source.is(DamageTypes.DROWN))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
		HollowBurrowProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putInt("Datasummoning_progress", this.entityData.get(DATA_summoning_progress));
		compound.putInt("Dataagitation", this.entityData.get(DATA_agitation));
		compound.putInt("Databurrow_progress", this.entityData.get(DATA_burrow_progress));
		compound.putInt("Dataheartbeat", this.entityData.get(DATA_heartbeat));
		compound.putInt("Datajump_cooldown", this.entityData.get(DATA_jump_cooldown));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
		if (compound.contains("Datasummoning_progress"))
			this.entityData.set(DATA_summoning_progress, compound.getInt("Datasummoning_progress"));
		if (compound.contains("Dataagitation"))
			this.entityData.set(DATA_agitation, compound.getInt("Dataagitation"));
		if (compound.contains("Databurrow_progress"))
			this.entityData.set(DATA_burrow_progress, compound.getInt("Databurrow_progress"));
		if (compound.contains("Dataheartbeat"))
			this.entityData.set(DATA_heartbeat, compound.getInt("Dataheartbeat"));
		if (compound.contains("Datajump_cooldown"))
			this.entityData.set(DATA_jump_cooldown, compound.getInt("Datajump_cooldown"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		HollowUpdateTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose pose) {
		return super.getDefaultDimensions(pose).scale(1f);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.35);
		builder = builder.add(Attributes.MAX_HEALTH, 65);
		builder = builder.add(Attributes.ARMOR, 4);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 14);
		builder = builder.add(Attributes.FOLLOW_RANGE, 48);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.3);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 1);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) && this.onGround()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("run"));
			}
			if (this.isDeadOrDying()) {
				return event.setAndContinue(RawAnimation.begin().thenPlay("death"));
			}
			if (!this.onGround()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("leap"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
		}
		return PlayState.STOP;
	}

	private PlayState attackingPredicate(AnimationState event) {
		double d1 = this.getX() - this.xOld;
		double d0 = this.getZ() - this.zOld;
		float velocity = (float) Math.sqrt(d1 * d1 + d0 * d0);
		if (getAttackAnim(event.getPartialTick()) > 0f && !this.swinging) {
			this.swinging = true;
			this.lastSwing = level().getGameTime();
		}
		if (this.swinging && this.lastSwing + 7L <= level().getGameTime()) {
			this.swinging = false;
		}
		if (this.swinging && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
			event.getController().forceAnimationReset();
			return event.setAndContinue(RawAnimation.begin().thenPlay("attack"));
		}
		return PlayState.CONTINUE;
	}

	String prevAnim = "empty";

	private PlayState procedurePredicate(AnimationState event) {
		if (!animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED || (!this.animationprocedure.equals(prevAnim) && !this.animationprocedure.equals("empty"))) {
			if (!this.animationprocedure.equals(prevAnim))
				event.getController().forceAnimationReset();
			event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				this.animationprocedure = "empty";
				event.getController().forceAnimationReset();
			}
		} else if (animationprocedure.equals("empty")) {
			prevAnim = "empty";
			return PlayState.STOP;
		}
		prevAnim = this.animationprocedure;
		return PlayState.CONTINUE;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 40) {
			this.remove(HollowEntity.RemovalReason.KILLED);
			this.dropExperience(this);
			HollowDeathProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController<>(this, "movement", 5, this::movementPredicate));
		data.add(new AnimationController<>(this, "attacking", 5, this::attackingPredicate));
		data.add(new AnimationController<>(this, "procedure", 5, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
