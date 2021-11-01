package io.github.navalarmamentsrebooted.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import org.apache.commons.lang3.tuple.Pair;

public class NavalArmamentsRebootedConfig {

    public static class Common {
        public final ConfigValue<Integer> woodenVaulDamage;
        public final ConfigValue<Integer> stoneVaulDamage;
        public final ConfigValue<Integer> ironVaulDamage;
        public final ConfigValue<Integer> goldenVaulDamage;
        public final ConfigValue<Integer> diamondVaulDamage;
        public final ConfigValue<Integer> netheriteVaulDamage;
        public final ConfigValue<Integer> emeraldVaulDamage;
        public final ConfigValue<Integer> tigersEyeVaulDamage;
        public final ConfigValue<Integer> amethystVaulDamage;
        public final ConfigValue<Integer> rubyVaulDamage;
        public final ConfigValue<Integer> ultimateVaulDamage;

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("Attack Damage");
            builder.push("Vaul");
            woodenVaulDamage = builder.define("Damage of the Wooden Vaul", 8);
            stoneVaulDamage = builder.define("Damage of the Stone Vaul", 10);
            ironVaulDamage = builder.define("Damage of the Iron Vaul", 11);
            goldenVaulDamage = builder.define("Damage of the Golden Vaul", 10);
            diamondVaulDamage = builder.define("Damage of the Diamond Vaul", 12);
            netheriteVaulDamage = builder.define("Damage of the Netherite Vaul", 13);
            //Chaos Awakens Integration
            emeraldVaulDamage = builder.define("Damage of the Emerald Vaul", 14);
            tigersEyeVaulDamage = builder.define("Damage of the Tiger's Eye Vaul", 12);
            amethystVaulDamage = builder.define("Damage of the Amethyst Vaul", 22);
            rubyVaulDamage = builder.define("Damage of the Amethyst Vaul", 28);
            ultimateVaulDamage = builder.define("Damage of the Ultimate Vaul", 45);
            builder.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
    }
}


