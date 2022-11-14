package content.events;


import content.items.EmeraldAxe;
import content.items.EmeraldHoe;
import content.items.EmeraldSword;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import scripts.Main;

import java.util.*;

import static net.minecraftforge.fml.common.Mod.*;

@EventBusSubscriber(modid = Main.MODID)
public class ModEvents {

    public static boolean isFromRaid(LivingEntity entity) {
        if (entity instanceof Pillager)
            return true;
        if (entity instanceof Vindicator)
            return true;
        if (entity instanceof Ravager)
            return true;
        if (entity instanceof Witch)
            return true;
        return entity instanceof Evoker;
    }

    @SubscribeEvent
    public static void MoreDamage(LivingHurtEvent event) {
        LivingEntity enemy = event.getEntity();
        if (!isFromRaid(enemy)) {
            return;
        }
        if (!(event.getSource().getEntity() instanceof Player player)) {
            return;
        }
        ItemStack itemStack = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (!(itemStack.getItem() instanceof EmeraldSword || player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof EmeraldAxe)) {
            return;
        }
        System.out.println("checking...");
        boolean flag = player.fallDistance > 0.0f && !player.isOnGround() && !player.isSuppressingSlidingDownLadder() && !player.isInWater() && itemStack.canPerformAction(net.minecraftforge.common.ToolActions.SWORD_SWEEP);;
        if (enemy instanceof Ravager && itemStack.getItem() instanceof EmeraldAxe && flag) {
            System.out.println("It is ravager and you have emerald axe");
            if (!player.getAbilities().instabuild) {
                System.out.println("you are in survival");
                itemStack.hurtAndBreak(3000, player, (p_150686_) -> {
                    p_150686_.broadcastBreakEvent(InteractionHand.MAIN_HAND);
                });
                System.out.println("broken axe be like:");
            }
            enemy.die(event.getSource());
            enemy.setHealth(0);
            System.out.println("Get died, noob!");
            return;
        }
        enemy.addEffect(new MobEffectInstance(Objects.requireNonNull(MobEffect.byId(7)), 10), player);
    }
}
