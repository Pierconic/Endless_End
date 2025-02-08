
package net.mcreator.endless_end.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RawEndoriteItem extends Item {
	public RawEndoriteItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
