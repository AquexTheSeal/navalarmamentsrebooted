package io.github.navalarmamentsrebooted.items;

import io.github.navalarmamentsrebooted.config.NavalArmamentsRebootedConfig;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        if (this.tippedEffect != null) {
            entity.addEffect(tippedEffect);
        }
        if ((EntityTypeTags.getAllTags().getTagOrEmpty(new ResourceLocation(("forge:vaul_targets").toLowerCase(java.util.Locale.ENGLISH)))
                .contains(entity.getType()))) {
            entity.hurt(DamageSource.GENERIC, getAttackDamage() + 5.0F);
        }

        entity.setDeltaMovement(0, 0.5, 0);
        return retval;
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        ActionResult<ItemStack> actionResult = super.use(world, entity, hand);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        List<Entity> _targets = world.getEntitiesOfClass(Entity.class, new AxisAlignedBB(entity.getX() - (NavalArmamentsRebootedConfig.COMMON.vaulSkillRange.get()  / 2d), entity.getY() - ((double) NavalArmamentsRebootedConfig.COMMON.vaulSkillRange.get() / 2d), entity.getZ() - ((double) NavalArmamentsRebootedConfig.COMMON.vaulSkillRange.get() / 2d), entity.getX() + ((double) NavalArmamentsRebootedConfig.COMMON.vaulSkillRange.get() / 2d), entity.getY() + ((double) NavalArmamentsRebootedConfig.COMMON.vaulSkillRange.get() / 2d), entity.getZ() + ((double) NavalArmamentsRebootedConfig.COMMON.vaulSkillRange.get() / 2d)), null)
                .stream().sorted(new Object() {
                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
                    }
                }.compareDistOf(entity.getX(), entity.getY(), entity.getZ())).collect(Collectors.toList());
        for (Entity targettedEntities : _targets) {
            if ((!(entity == targettedEntities))) {
                targettedEntities.setDeltaMovement(0, 0.5, 0);
                targettedEntities.hurt(DamageSource.MAGIC, (float) NavalArmamentsRebootedConfig.COMMON.vaulSkillDamage.get());
                /*((ServerWorld) world).sendParticles(ParticleTypes.POOF, (targettedEntities.getX()), (targettedEntities.getY()),
                        (targettedEntities.getZ()), (int) 20, 0.2, 0.2, 0.2, 0.1);*/
            }
        }
        ((PlayerEntity) entity).getCooldowns().addCooldown((this.getItem()).getItem(), (int) 200);
        ((ClientWorld) world).playLocalSound(x, y, z,
                (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")),
                SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
        return actionResult;
    }
}