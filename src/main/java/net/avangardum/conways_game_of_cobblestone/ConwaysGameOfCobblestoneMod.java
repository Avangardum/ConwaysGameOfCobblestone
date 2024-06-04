package net.avangardum.conways_game_of_cobblestone;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ConwaysGameOfCobblestoneMod.MOD_ID)
public class ConwaysGameOfCobblestoneMod
{
    public static final String MOD_ID = "conways_game_of_cobblestone";

    public ConwaysGameOfCobblestoneMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntityTypes.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
