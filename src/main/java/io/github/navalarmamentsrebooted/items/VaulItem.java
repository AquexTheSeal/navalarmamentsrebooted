package io.github.navalarmamentsrebooted.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class VaulItem extends AxeItem {
    protected EffectInstance tippedEffect;
    protected EffectInstance tippedEffect2;

    public VaulItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    public VaulItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, EffectInstance effect, EffectInstance effect2, Item.Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
        this.tippedEffect = effect;
        this.tippedEffect2 = effect2;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity entity, LivingEntity source) {
        boolean retval = super.hurtEnemy(stack, entity, source);
        if (this.tippedEffect != null) {
            entity.addEffect(tippedEffect);
            entity.addEffect(tippedEffect2);
        }

        entity.setDeltaMovement(0, 0.5, 0);
        return retval;
    }
}