
package net.mcreator.endless_end.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class EndoriteIngotItem extends Item {
	public EndoriteIngotItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
