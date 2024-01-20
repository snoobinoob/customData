package customdata;

import necesse.engine.commands.CommandsManager;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.LevelDataRegistry;
import necesse.engine.registries.WorldDataRegistry;

@ModEntry
public class CustomdataEntry {
    public void init() {
        LevelDataRegistry.registerLevelData(CustomLevelData.DATA_KEY, CustomLevelData.class);
        WorldDataRegistry.registerWorldData(CustomWorldData.DATA_KEY, CustomWorldData.class);
    }

    public void postInit() {
        CommandsManager.registerServerCommand(new CommandLevelData());
        CommandsManager.registerServerCommand(new CommandWorldData());
    }
}