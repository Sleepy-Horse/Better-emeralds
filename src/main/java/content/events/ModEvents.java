package content.events;


import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import scripts.Main;
import scripts.registers.ModItems;

import static net.minecraftforge.fml.common.Mod.*;

@EventBusSubscriber(modid = Main.MODID)
public class ModEvents {
    @SubscribeEvent
    public void MoreDamage(AttackEntityEvent event){
        Player player = event.getEntity();
        System.out.println("Checking");
        if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.EMERALD_SWORD.get())){
            System.out.println("You hit with emerald sword!");
        }
    }

    @SubscribeEvent
    public void test(LivingEvent.LivingJumpEvent event){
        System.out.println(event.getEntity());
    }
}
