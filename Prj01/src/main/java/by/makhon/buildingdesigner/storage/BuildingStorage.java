package by.makhon.buildingdesigner.storage;

import by.makhon.buildingdesigner.bean.Building;

import java.util.List;

public interface BuildingStorage {
    static BuildingStorage getInstance() {
        return BuildingStorageImpl.getInstance();
    }

    List<Building> getBuildingStorage();
}
