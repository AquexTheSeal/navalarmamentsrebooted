package io.github.navalarmamentsrebooted.registry;

import io.github.chaosawakens.common.enums.CAItemTier;
import io.github.chaosawakens.common.registry.CAItemGroups;
import io.github.navalarmamentsrebooted.NavalArmamentsRebooted;
import io.github.navalarmamentsrebooted.config.NavalArmamentsRebootedConfig;
import io.github.navalarmamentsrebooted.items.CeriseItem;
import io.github.navalarmamentsrebooted.items.EnchantedVaulItem;
import io.github.navalarmamentsrebooted.items.VaulItem;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NavalArmamentsRebootedItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NavalArmamentsRebooted.MOD_ID);

    //VAULS (HEAVY HAMMERS / AXES)
    public static final RegistryObject<Item> WOODEN_VAUL = ITEMS.register("wooden_vaul", ()-> new VaulItem(ItemTier.WOOD, NavalArmamentsRebootedConfig.COMMON.woodenVaulDamage.get()-1, -3.5f, new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 10, 1), new Item.Properties().rarity(Rarity.COMMON).durability(450).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> STONE_VAUL = ITEMS.register("stone_vaul", ()-> new VaulItem(ItemTier.STONE, NavalArmamentsRebootedConfig.COMMON.stoneVaulDamage.get()-2, -3.45f, new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 10, 1), new Item.Properties().rarity(Rarity.COMMON).durability(560).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_VAUL = ITEMS.register("iron_vaul", ()-> new VaulItem(ItemTier.IRON, NavalArmamentsRebootedConfig.COMMON.ironVaulDamage.get()-3, -3.40f, new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 10, 1), new Item.Properties().rarity(Rarity.COMMON).durability(890).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> GOLDEN_VAUL = ITEMS.register("golden_vaul", ()-> new VaulItem(ItemTier.GOLD, NavalArmamentsRebootedConfig.COMMON.goldenVaulDamage.get()-1, -3.35f, new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 10, 1), new Item.Properties().rarity(Rarity.COMMON).durability(250).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> DIAMOND_VAUL = ITEMS.register("diamond_vaul", ()-> new VaulItem(ItemTier.DIAMOND, NavalArmamentsRebootedConfig.COMMON.diamondVaulDamage.get()-4, -3.35f, new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 15, 2), new Item.Properties().rarity(Rarity.COMMON).durability(1290).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> NETHERITE_VAUL = ITEMS.register("netherite_vaul", ()-> new VaulItem(ItemTier.NETHERITE, Math.abs(NavalArmamentsRebootedConfig.COMMON.netheriteVaulDamage.get())-5, -3.30f, new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 15, 2), new Item.Properties().rarity(Rarity.COMMON).durability(3590).tab(ItemGroup.TAB_COMBAT)));

    //VAULS (HEAVY HAMMERS / AXES) [Chaos Awakens Integration]
    public static final RegistryObject<Item> EMERALD_VAUL = ITEMS.register("emerald_vaul", ()-> new VaulItem(CAItemTier.TOOL_EMERALD, NavalArmamentsRebootedConfig.COMMON.emeraldVaulDamage.get()-7, -3.30f, new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 15, 2), new Item.Properties().rarity(Rarity.COMMON).durability(4435).tab(CAItemGroups.equipmentItemGroup)));
    public static final RegistryObject<Item> TIGERS_EYE_VAUL = ITEMS.register("tigers_eye_vaul", ()-> new VaulItem(CAItemTier.TOOL_TIGERS_EYE, NavalArmamentsRebootedConfig.COMMON.tigersEyeVaulDamage.get()-9, -3.30f, new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 10, 1), new Item.Properties().rarity(Rarity.COMMON).durability(6556).tab(CAItemGroups.equipmentItemGroup)));
    public static final RegistryObject<Item> AMETHYST_VAUL = ITEMS.register("amethyst_vaul", ()-> new VaulItem(CAItemTier.TOOL_AMETHYST, NavalArmamentsRebootedConfig.COMMON.amethystVaulDamage.get()-12, -3.25f, new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 15, 2), new Item.Properties().rarity(Rarity.COMMON).durability(5267).tab(CAItemGroups.equipmentItemGroup)));
    public static final RegistryObject<Item> RUBY_VAUL = ITEMS.register("ruby_vaul", ()-> new VaulItem(CAItemTier.TOOL_RUBY, NavalArmamentsRebootedConfig.COMMON.rubyVaulDamage.get()-17, -3.25f, new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 15, 2), new Item.Properties().rarity(Rarity.COMMON).durability(5943).tab(CAItemGroups.equipmentItemGroup)));
    public static final RegistryObject<Item> ULTIMATE_VAUL = ITEMS.register("ultimate_vaul", () -> new EnchantedVaulItem(CAItemTier.TOOL_ULTIMATE, NavalArmamentsRebootedConfig.COMMON.ultimateVaulDamage.get()-38, -3.20f, new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 15, 2), new Item.Properties().rarity(Rarity.EPIC).durability(8540).tab(CAItemGroups.equipmentItemGroup),
            new EnchantmentData[]{new EnchantmentData(Enchantments.SHARPNESS, 3), new EnchantmentData(Enchantments.MOB_LOOTING, 3), new EnchantmentData(Enchantments.UNBREAKING, 2), new EnchantmentData(Enchantments.FIRE_ASPECT, 2)}));

    //CERISES (HEAVY CROSSBOWS)
    public static final RegistryObject<Item> WOODEN_CERISE = ITEMS.register("wooden_cerise", ()-> new CeriseItem(new Item.Properties().rarity(Rarity.COMMON).durability(120)/*.tab(ItemGroup.TAB_COMBAT)*/));

    //CERISES (HEAVY CROSSBOWS) [Chaos Awakens Integration]
    public static final RegistryObject<Item> RUBY_CERISE = ITEMS.register("ruby_cerise", ()-> new CeriseItem(new Item.Properties().rarity(Rarity.COMMON).durability(8540)/*.tab(CAItemGroups.equipmentItemGroup)*/));
}