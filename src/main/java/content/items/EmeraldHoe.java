package content.items;

import com.mojang.datafixers.util.Pair;
import content.customthings.CustomTiers;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EmeraldHoe extends HoeItem {
    public static final Item[] crops = {Items.WHEAT_SEEDS, Items.BEETROOT_SEEDS, Items.POTATO, Items.CARROT};

    public EmeraldHoe() {
        super(CustomTiers.EMERALD, -2, -1.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState toolModifiedState = level.getBlockState(blockpos).getToolModifiedState(context, net.minecraftforge.common.ToolActions.HOE_TILL, false);
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, changeIntoState(toolModifiedState));
        if (pair == null) {
            return InteractionResult.PASS;
        } else {
            Predicate<UseOnContext> predicate = pair.getFirst();
            Consumer<UseOnContext> consumer = pair.getSecond();
            if (predicate.test(context)) {
                Player player = context.getPlayer();
                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!level.isClientSide) {
                    consumer.accept(context);
                    if (player != null) {
                        blockpos = blockpos.above();
                        Map<Item, ItemStack> dic = new HashMap<Item, ItemStack>();
                        Random rand = new Random();
                        if (rand.nextBoolean()) {
                            for (ItemStack itemStack : player.getInventory().items) {
                                if (Arrays.stream(crops).anyMatch(cropItem -> cropItem == itemStack.getItem())
                                ) {
                                    //System.out.println(dic.get(itemStack.getItem()).getCount() + "you got setted");
                                    if (!Arrays.asList(dic.keySet().toArray()).contains(itemStack.getItem()) || dic.get(itemStack.getItem()).getCount() >= itemStack.getCount()) {
                                        dic.put(itemStack.getItem(), itemStack);
                                    }
                                }
                            }
                            ItemStack itemStack = (ItemStack) dic.values().toArray()[rand.nextInt(dic.size())];

                            BlockState blockState = ((BlockItem) itemStack.getItem()).getBlock().defaultBlockState();
                            //level.setBlock(blockpos, blockState, 1);
                            level.setBlockAndUpdate(blockpos, blockState);
                            if ((rand.nextBoolean()) && !player.getAbilities().instabuild) {
                                itemStack.shrink(1);
                            }
                            context.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                        }
                    }
                };
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }
    }
}
