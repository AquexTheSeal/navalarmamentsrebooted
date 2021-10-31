package io.github;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.navalarmamentsrebooted.registry.NavalArmamentsRebootedItems;

@Mod(NavalArmamentsRebooted.MOD_ID)
public class NavalArmamentsRebooted {
    public static NavalArmamentsRebooted instance;

    public static final String MOD_ID = "navalarmamentsrebooted";
    public static final String MOD_NAME = "Naval Armaments: Rebooted";
    private static final Logger LOGGER = LogManager.getLogger();

    public NavalArmamentsRebooted() {
        instance = this;
        /** NOTE 1a: so that we won't have to redundantly refer to getting the mod event bus,
         * we need to make this object, such that we can refer to THIS one later on instead of
         * `FMLJavaModLoadingContext.get().getModEventBus()` every single time
        **/
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // NOTE 1b: final step of registering elements like Items, Entities, etc. by passing their deferred register onto the bus
        NavalArmamentsRebootedItems.ITEMS.register(bus);

        // NOTE 1c: add listeners for everything else
        bus.addListener(this::setup);


        // NOTE 1d: register this class through the Minecraft Forge Event Bus
        MinecraftForge.EVENT_BUS.register(this);
    }

    // NOTE 2a: do some things during the setup phase of this mod, most preferably sending logs or whatever
    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("[" + MOD_NAME + "] - no.");
        LOGGER.info("Cool weaponry mod. Yes.");
    }
}
