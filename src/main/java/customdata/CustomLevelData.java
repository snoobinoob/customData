package customdata;

import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;
import necesse.level.maps.Level;
import necesse.level.maps.levelData.LevelData;

public class CustomLevelData extends LevelData {
    public static final String DATA_KEY = "customleveldata";
    public int data;

    @Override
    public void setLevel(Level level) {
        super.setLevel(level);
        // Do whatever initialization you need here
    }

    @Override
    public void tick() {
        // Add whatever logic you want to execute on every tick
    }

    @Override
    public boolean shouldSave() {
        // Return false if you do not want the data saved
        // No need to implement addSaveData and applyLoadData if data is never saved
        return true;
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

    public static CustomLevelData getCustomLevelData(Level level) {
        LevelData customData = level.getLevelData(DATA_KEY);
        if (customData instanceof CustomLevelData) {
            return (CustomLevelData) customData;
        }
        CustomLevelData newData = new CustomLevelData();
        level.addLevelData(DATA_KEY, newData);
        return newData;
    }
}
