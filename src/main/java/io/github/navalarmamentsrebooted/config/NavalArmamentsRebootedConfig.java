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
        //Chaos Awakens Integration
        public final ConfigValue<Integer> emeraldVaulDamage;
        public final ConfigValue<Integer> tigersEyeVaulDamage;
        public final ConfigValue<Integer> amethystVaulDamage;
        public final ConfigValue<Integer> rubyVaulDamage;
        public final ConfigValue<Integer> ultimateVaulDamage;
        //Weapon Skill Stats
        public final ConfigValue<Integer> vaulSkillDamage;
        public final ConfigValue<Double> vaulSkillRange;

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("Attack Damage");
            builder.push("Vaul");
            woodenVaulDamage = builder.define("Damage of the Wooden Vaul", 9);
            stoneVaulDamage = builder.define("Damage of the Stone Vaul", 12);
            ironVaulDamage = builder.define("Damage of the Iron Vaul", 13);
            goldenVaulDamage = builder.define("Damage of the Golden Vaul", 9);
            diamondVaulDamage = builder.define("Damage of the Diamond Vaul", 14);
            netheriteVaulDamage = builder.define("Damage of the Netherite Vaul", 16);
            //Chaos Awakens Integration
            emeraldVaulDamage = builder.define("Damage of the Emerald Vaul", 18);
            tigersEyeVaulDamage = builder.define("Damage of the Tiger's Eye Vaul", 20);
            amethystVaulDamage = builder.define("Damage of the Amethyst Vaul", 23);
            rubyVaulDamage = builder.define("Damage of the Amethyst Vaul", 28);
            ultimateVaulDamage = builder.define("Damage of the Ultimate Vaul (Usually added by +1)", 51);

            //Weapon Skill Stats
            builder.push("Weapon Skill Stats");
            vaulSkillDamage = builder.define("Default damage of the Vauls' skill", 3);
            vaulSkillRange = builder.define("Default range of the Vauls' skill (measured in blocks) (must add a 'd' at the end of the number to function properly.)", 7d);
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


