package content.items.tools;

import content.customthings.CustomTiers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tiers;

public class EmeraldShovel extends ShovelItem {
    public EmeraldShovel(){
        super(CustomTiers.EMERALD_SHOVEL, 1.5F, -3.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS));
    }
}
