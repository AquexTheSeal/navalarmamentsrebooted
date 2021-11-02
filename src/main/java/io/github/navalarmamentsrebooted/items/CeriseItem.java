package io.github.navalarmamentsrebooted.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CeriseItem extends CrossbowItem {
    private boolean startSoundPlayed = false;
    private boolean midLoadSoundPlayed = false;

    public CeriseItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack inHand = p_77659_2_.getItemInHand(p_77659_3_);
        if (isCharged(inHand)) {
            performShooting(p_77659_1_, p_77659_2_, p_77659_3_, inHand, getShootingPower(inHand), 3.0F);
            setCharged(inHand, false);
            return ActionResult.consume(inHand);
        } else if (!p_77659_2_.getProjectile(inHand).isEmpty()) {
            if (!isCharged(inHand)) {
                this.startSoundPlayed = false;
                this.midLoadSoundPlayed = false;
                p_77659_2_.startUsingItem(p_77659_3_);
            }

            return ActionResult.consume(inHand);
        } else {
            return ActionResult.fail(inHand);
        }
    }

    private static float getShootingPower(ItemStack var0) {
        return var0.getItem() == Items.CROSSBOW && containsChargedProjectile(var0, Items.FIREWORK_ROCKET) ? 3.2F : 6.50F;
    }

    public int getDefaultProjectileRange() {
        return 16;
    }
}

