package content.items.tools;

import content.customthings.CustomTiers;
import net.minecraft.world.item.*;

public class EmeraldSword extends SwordItem {
    public EmeraldSword() {
        super(CustomTiers.EMERALD, 3, -2.4F, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).setNoRepair());
    }
}
