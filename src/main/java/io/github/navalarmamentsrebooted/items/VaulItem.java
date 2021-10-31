package io.github.navalarmamentsrebooted.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;

public class VaulItem extends AxeItem {
    protected EffectInstance tippedEffect;

    public VaulItem(ItemTier tier, int attackDamage, float attackSpeed, Item.Properties builder) {
        super(tier, attackDamage, attackSpeed, builder);
    }

    public VaulItem(ItemTier tier, int attackDamage, float attackSpeed, EffectInstance effect, Item.Properties builder) {
        super(tier, attackDamage, attackSpeed, builder);
        this.tippedEffect = effect;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity entity, LivingEntity source) {
        boolean retval = super.hurtEnemy(stack, entity, source);
        if(this.tippedEffect != null) {
            entity.addEffect(tippedEffect);
        }

        entity.setDeltaMovement((entity.getMotionDirection().getStepX()), 0.5, ((entity.getMotionDirection().getStepZ())));
        return retval;
    }
}