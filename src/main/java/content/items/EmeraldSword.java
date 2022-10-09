package content.items;

import net.minecraft.world.item.*;

public class EmeraldSword extends SwordItem {
    public EmeraldSword() {
        super(Tiers.IRON, 3, -2.4F, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT));
    }
}
