package content.items.tools;

import content.customthings.CustomTiers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class EmeraldPickaxe extends PickaxeItem {
    public EmeraldPickaxe() {
        super(CustomTiers.EMERALD, 1, -2.8F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS));
    }
}
