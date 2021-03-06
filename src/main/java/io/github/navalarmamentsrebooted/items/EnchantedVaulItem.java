package io.github.navalarmamentsrebooted.items;

import io.github.chaosawakens.api.IAutoEnchantable;
import io.github.chaosawakens.common.config.CAConfig;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.NonNullList;

//For chaos awakens' ultimate gear support
public class EnchantedVaulItem extends VaulItem implements IAutoEnchantable {

    private final EnchantmentData[] enchantments;

    public EnchantedVaulItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, EffectInstance effectInstance, Item.Properties builderIn, EnchantmentData[] enchantments) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
        this.enchantments = enchantments;
    }

    @Override
    public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.allowdedIn(group)) {
            ItemStack stack = new ItemStack(this);
            if (CAConfig.COMMON.enableAutoEnchanting.get())
                for(EnchantmentData enchant : enchantments) {
                    stack.enchant( enchant.enchantment, enchant.level);
                }
            items.add(stack);
        }
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return CAConfig.COMMON.enableAutoEnchanting.get() || super.isFoil(stack);
    }

    @Override
    public EnchantmentData[] enchantments() {
        return this.enchantments;
    }
}