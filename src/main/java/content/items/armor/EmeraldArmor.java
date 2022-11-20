package content.items.armor;

import content.customthings.CustomArmorMaterials;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public abstract class EmeraldArmor{
    public static ArmorItem emerald_helmet = new ArmorItem(CustomArmorMaterials.EMERALD, EquipmentSlot.HEAD, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT));
    public static ArmorItem emerald_chestplate = new ArmorItem(CustomArmorMaterials.EMERALD, EquipmentSlot.CHEST, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT));
    public static ArmorItem emerald_leggings = new ArmorItem(CustomArmorMaterials.EMERALD, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT));
    public static ArmorItem emerald_boots = new ArmorItem(CustomArmorMaterials.EMERALD, EquipmentSlot.FEET, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT));

}
