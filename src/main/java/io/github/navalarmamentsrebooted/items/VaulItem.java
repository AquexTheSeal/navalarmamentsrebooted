package io.github.navalarmamentsrebooted.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;

public class VaulItem extends AxeItem {
    protected EffectInstance tippedEffect;

    public VaulItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    public VaulItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, EffectInstance effect, Item.Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
        this.tippedEffect = effect;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity entity, LivingEntity source) {
        boolean retval = super.hurtEnemy(stack, entity, source);
        if(this.tippedEffect != null) {
            entity.addEffect(tippedEffect);
        }

        entity.setDeltaMovement(0, 0.5, 0);
        return retval;
    }
}