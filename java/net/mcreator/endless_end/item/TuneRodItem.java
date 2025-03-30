
package net.mcreator.endless_end.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TuneRodItem extends Item {
	public TuneRodItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
