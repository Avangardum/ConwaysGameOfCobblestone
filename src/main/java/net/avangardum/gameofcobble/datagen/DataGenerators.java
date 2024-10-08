package net.avangardum.gameofcobble.datagen;

import net.avangardum.gameofcobble.GameOfCobbleMod;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = GameOfCobbleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
final class DataGenerators {
    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
        var generator = event.getGenerator();
        var packOutput = generator.getPackOutput();
        var existingFileHelper = event.getExistingFileHelper();
        var lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModLootTableProvider(packOutput));
        generator.addProvider(event.includeServer(),
                new ModBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
    }
}
