package content.events;


import content.items.EmeraldSword;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import scripts.Main;
import scripts.registers.ModItems;

import java.util.Objects;

import static net.minecraftforge.fml.common.Mod.*;

@EventBusSubscriber(modid = Main.MODID)
public class ModEvents {
    public static boolean isFromRaid(LivingEntity entity){
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
        if (!isFromRaid(event.getEntity())) {
            return;
        }
        if (!(event.getSource().getEntity() instanceof Player player)) {
            return;
        }
        if (!(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof EmeraldSword)) {
            return;
        }
        event.getEntity().addEffect(new MobEffectInstance(Objects.requireNonNull(MobEffect.byId(7)), 10), player);
    }
}
