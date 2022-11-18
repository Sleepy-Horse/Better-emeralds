package scripts.registers;

import content.items.EmeraldAxe;
import content.items.EmeraldHoe;
import content.items.EmeraldPickaxe;
import content.items.EmeraldSword;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import scripts.Main;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", EmeraldSword::new);
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", EmeraldAxe::new);
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", EmeraldHoe::new);
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", EmeraldPickaxe::new);



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
