package io.github.navalarmamentsrebooted;


import com.google.common.collect.Maps;
import io.github.navalarmamentsrebooted.items.CeriseItem;
import io.github.navalarmamentsrebooted.registry.NavalArmamentsRebootedItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import javax.annotation.Nullable;
import java.util.Map;

@Mod.EventBusSubscriber(modid = NavalArmamentsRebooted.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NavalArmamentsRebootedClient {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void registerModels(final FMLClientSetupEvent event) {
        ItemModelsProperties.register(NavalArmamentsRebootedItems.WOODEN_CERISE.get(), new ResourceLocation("pull"), (itemStack, clientWorld, livingEntity) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return CeriseItem.isCharged(itemStack) ? 0.0F : (float) (itemStack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / (float) CeriseItem.getChargeDuration(itemStack);
            }
        });
        ItemModelsProperties.register(NavalArmamentsRebootedItems.WOODEN_CERISE.get(), new ResourceLocation("pulling"), (itemStack, clientWorld, livingEntity) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack && !CeriseItem.isCharged(itemStack) ? 1.0F : 0.0F;
        });
        ItemModelsProperties.register(NavalArmamentsRebootedItems.WOODEN_CERISE.get(), new ResourceLocation("charged"), (itemStack, clientWorld, livingEntity) -> {
            return livingEntity != null && CeriseItem.isCharged(itemStack) ? 1.0F : 0.0F;
        });
        ItemModelsProperties.register(NavalArmamentsRebootedItems.WOODEN_CERISE.get(), new ResourceLocation("firework"), (itemStack, clientWorld, livingEntity) -> {
            return livingEntity != null && CeriseItem.isCharged(itemStack) && CeriseItem.containsChargedProjectile(itemStack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });

        ItemModelsProperties.register(NavalArmamentsRebootedItems.RUBY_CERISE.get(), new ResourceLocation("pull"), (itemstack, world, entity) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return CrossbowItem.isCharged(itemstack) ? 0.0F : (float) (itemstack.getUseDuration() - entity.getUseItemRemainingTicks()) / (float) CrossbowItem.getChargeDuration(itemstack);
            }
        });

        ItemModelsProperties.register(NavalArmamentsRebootedItems.RUBY_CERISE.get(), new ResourceLocation("pulling"), (var0, p_239426_1_, p_239426_2_) -> {
            return p_239426_2_ != null && p_239426_2_.isUsingItem() && p_239426_2_.getUseItem() == var0 && !CrossbowItem.isCharged(var0) ? 1.0F : 0.0F;
        });
        ItemModelsProperties.register(NavalArmamentsRebootedItems.RUBY_CERISE.get(), new ResourceLocation("charged"), (var0, p_239425_1_, p_239425_2_) -> {
            return p_239425_2_ != null && CrossbowItem.isCharged(var0) ? 1.0F : 0.0F;
        });
        ItemModelsProperties.register(NavalArmamentsRebootedItems.RUBY_CERISE.get(), new ResourceLocation("firework"), (var0, p_239424_1_, p_239424_2_) -> {
            return p_239424_2_ != null && CrossbowItem.isCharged(var0) && CrossbowItem.containsChargedProjectile(var0, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });
    }
}