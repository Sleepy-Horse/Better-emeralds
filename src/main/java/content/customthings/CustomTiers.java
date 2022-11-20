//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package content.customthings;

import java.util.function.Supplier;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public enum CustomTiers implements Tier{
    EMERALD(2, 250, 6.0F, 2.0F, 14, () -> {
        return Ingredient.of(Items.EMERALD);
    }),
    EMERALD_SHOVEL(2, 250, 13.2F, 2.0F, 14, () -> {
        return Ingredient.of(Items.EMERALD);
    });


    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private CustomTiers(int level, int durability, float mineSpeed, float damage, int enchantedLuck, Supplier repairItem) {
        this.level = level;
        this.uses = durability;
        this.speed = mineSpeed;
        this.damage = damage;
        this.enchantmentValue = enchantedLuck;
        this.repairIngredient = new LazyLoadedValue(repairItem);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
