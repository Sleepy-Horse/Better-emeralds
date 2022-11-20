package content.items.tools;

import content.customthings.CustomTiers;
import net.minecraft.world.item.*;

public class EmeraldAxe extends AxeItem {
    public EmeraldAxe() {
        super(CustomTiers.EMERALD, 6.0F, -3.1F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS).craftRemainder(Items.EMERALD));
    }
}
