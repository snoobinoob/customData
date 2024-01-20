package customdata;

import necesse.engine.network.server.Server;
import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;
import necesse.engine.world.WorldEntity;
import necesse.engine.world.worldData.WorldData;

public class CustomWorldData extends WorldData {
    public static final String DATA_KEY = "customworlddata";
    public int data;

    @Override
    public void setWorldEntity(WorldEntity worldEntity) {
        super.setWorldEntity(worldEntity);
        // Do whatever initialization you need here
    }

    @Override
    public void tick() {
        // Add whatever logic you want to execute on every tick
    }

    @Override
    public void addSaveData(SaveData save) {
        super.addSaveData(save);
        save.addInt("data", data);
    }

    @Override
    public void applyLoadData(LoadData save) {
        super.applyLoadData(save);
        data = save.getInt("data", data);
    }

    public static CustomWorldData getCustomWorldData(Server server) {
        WorldData customData = server.world.worldEntity.getWorldData(DATA_KEY);
        if (customData instanceof CustomWorldData) {
            return (CustomWorldData) customData;
        }
        CustomWorldData newData = new CustomWorldData();
        server.world.worldEntity.addWorldData(DATA_KEY, newData);
        return newData;
    }
}
