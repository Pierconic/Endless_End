
package net.mcreator.endless_end.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.endless_end.init.EndlessEndModFluids;

public class EssenceItem extends BucketItem {
	public EssenceItem() {
		super(EndlessEndModFluids.ESSENCE.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.UNCOMMON));
	}
}
