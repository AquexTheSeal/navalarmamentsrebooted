package io.github.navalarmamentsrebooted.items;

import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CeriseItem extends CrossbowItem implements IVanishable {
    private boolean startSoundPlayed = false;
    private boolean midLoadSoundPlayed = false;

    public CeriseItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack lvt_4_1_ = p_77659_2_.getItemInHand(p_77659_3_);
        if (isCharged(lvt_4_1_)) {
            performShooting(p_77659_1_, p_77659_2_, p_77659_3_, lvt_4_1_, getShootingPower(lvt_4_1_), 3.0F);
            setCharged(lvt_4_1_, false);
            return ActionResult.consume(lvt_4_1_);
        } else if (!p_77659_2_.getProjectile(lvt_4_1_).isEmpty()) {
            if (!isCharged(lvt_4_1_)) {
                this.startSoundPlayed = false;
                this.midLoadSoundPlayed = false;
                p_77659_2_.startUsingItem(p_77659_3_);
            }

            return ActionResult.consume(lvt_4_1_);
        } else {
            return ActionResult.fail(lvt_4_1_);
        }
    }

    private static float getShootingPower(ItemStack var0) {
        return var0.getItem() == Items.CROSSBOW && containsChargedProjectile(var0, Items.FIREWORK_ROCKET) ? 1.6F : 3.15F;
    }

    public int getDefaultProjectileRange() {
        return 8;
    }
}

