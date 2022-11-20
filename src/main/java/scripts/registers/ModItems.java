package scripts.registers;

import content.items.armor.EmeraldArmor;
import content.items.tools.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import scripts.Main;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet", () -> EmeraldArmor.emerald_helmet);
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", () -> EmeraldArmor.emerald_chestplate);
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", () -> EmeraldArmor.emerald_leggings);
    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots", () -> EmeraldArmor.emerald_boots);
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", EmeraldSword::new);
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", EmeraldPickaxe::new);
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", EmeraldAxe::new);
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", EmeraldShovel::new);
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", EmeraldHoe::new);



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
