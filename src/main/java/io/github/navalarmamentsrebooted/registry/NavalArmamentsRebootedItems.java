package io.github.navalarmamentsrebooted.registry;

import io.github.NavalArmamentsRebooted;
import io.github.chaosawakens.common.enums.CAItemTier;
import io.github.chaosawakens.common.registry.CAItemGroups;
import io.github.navalarmamentsrebooted.items.EnchantedVaulItem;
import io.github.navalarmamentsrebooted.items.VaulItem;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NavalArmamentsRebootedItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NavalArmamentsRebooted.MOD_ID);

    //VAULS (HEAVY HAMMERS / AXES)
    public static final RegistryObject<Item> WOODEN_VAUL = ITEMS.register("wooden_vaul", ()-> new VaulItem(ItemTier.WOOD, 12, -2.5f, new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 10, 1), new Item.Properties().rarity(Rarity.EPIC).durability(3540).tab(CAItemGroups.equipmentItemGroup)));

    public static final RegistryObject<Item> ULTIMATE_VAUL = ITEMS.register("ultimate_vaul", () -> new EnchantedVaulItem(CAItemTier.TOOL_ULTIMATE, 45, -2.5f, new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 10, 1), new Item.Properties().rarity(Rarity.EPIC).durability(3540).tab(CAItemGroups.equipmentItemGroup),
            new EnchantmentData[]{new EnchantmentData(Enchantments.SHARPNESS, 3), new EnchantmentData(Enchantments.MOB_LOOTING, 3), new EnchantmentData(Enchantments.UNBREAKING, 2), new EnchantmentData(Enchantments.FIRE_ASPECT, 2)}));
}
