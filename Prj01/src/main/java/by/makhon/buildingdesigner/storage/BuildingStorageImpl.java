package by.makhon.buildingdesigner.storage;

import by.makhon.buildingdesigner.bean.Building;
import by.makhon.buildingdesigner.bean.LightingDevice;
import by.makhon.buildingdesigner.bean.Room;
import by.makhon.buildingdesigner.bean.RoomItem;

import java.util.ArrayList;
import java.util.List;


public class BuildingStorageImpl implements BuildingStorage {

    private static BuildingStorageImpl ourInstance = new BuildingStorageImpl();

    private BuildingStorageImpl() {

    }

    public static BuildingStorageImpl getInstance(){
        return ourInstance;
    }

    @Override
    public List<Building> getBuildingStorage() {

        List<Building> buildings = new ArrayList<>();

        Building building1 = new Building("Building 1");
        Building building2 = new Building("Building 2");
        Building building3 = new Building("Building 3");
        //-------------------------BUILDING 1-------------------------//

        Room room411 = buildRoom("Room 411", 3, 100);
        room411.addLightingDevice(buildLightingDevice("Lamp", 150));
        room411.addLightingDevice(buildLightingDevice("Chandelier", 450));
        room411.addLightingDevice(buildLightingDevice("Light bulb", 150));
        room411.addRoomItem(buildRoomItem("Chair", 3, 5));
        room411.addRoomItem(buildRoomItem("Table", 4, 4));
        building1.addRoom(room411);


        building1.addRoom(buildRoom("Room 109", 2, 215));
        building1.getRoomByName("Room 109").addLightingDevice(buildLightingDevice("Lamp", 250));
        building1.getRoomByName("Room 109").addLightingDevice(buildLightingDevice("Chandelier", 395));
        building1.getRoomByName("Room 109").addLightingDevice(buildLightingDevice("Light bulb", 100));
        building1.getRoomByName("Room 109").addRoomItem(buildRoomItem("Sofa", 6, 9));
        building1.getRoomByName("Room 109").addRoomItem(buildRoomItem("Chair", 2, 4));

        //-------------------------BUILDING 2-------------------------//
        building2.addRoom(buildRoom("Room 314", 2, 74));
        building2.getRoomByName("Room 314").addLightingDevice(buildLightingDevice("Light bulb", 150));
        building2.getRoomByName("Room 314").addLightingDevice(buildLightingDevice("Light bulb", 250));
        building2.getRoomByName("Room 314").addLightingDevice(buildLightingDevice("Chandelier", 550));
        building2.getRoomByName("Room 314").addRoomItem(buildRoomItem("Shelf", 4, 7));
        building2.getRoomByName("Room 314").addRoomItem(buildRoomItem("Cabinet", 7, 10));

        building2.addRoom(buildRoom("Room 212", 1, 30));
        building2.getRoomByName("Room 212").addLightingDevice(buildLightingDevice("Chandelier", 350));
        building2.getRoomByName("Room 212").addLightingDevice(buildLightingDevice("Light bulb", 250));
        building2.getRoomByName("Room 212").addRoomItem(buildRoomItem("Sofa", 4, 6));
        building2.getRoomByName("Room 212").addRoomItem(buildRoomItem("Chair", 2, 2));

        //-------------------------BUILDING 3-------------------------//

        building3.addRoom(buildRoom("Room 309", 4, 150));
        building3.getRoomByName("Room 309").addRoomItem(buildRoomItem("Chair", 4, 6));
        building3.getRoomByName("Room 309").addLightingDevice(buildLightingDevice("Lamp", 300));

        buildings.add(building1);
        buildings.add(building2);
        buildings.add(building3);

        return buildings;
    }

    private Room buildRoom(String roomName, int windowsAmount, double roomArea) {
        return Room.RoomBuilder.create()
                .withRoomName(roomName)
                .withWindowsAmount(windowsAmount)
                .withRoomArea(roomArea)
                .build();
    }

    private RoomItem buildRoomItem(String roomItemName, double minRoomItemArea, double maxRoomItemArea) {
        return RoomItem.RoomItemBuilder.create()
                .withRoomItemName(roomItemName)
                .withMinRoomItemArea(minRoomItemArea)
                .withMaxRoomItemArea(maxRoomItemArea)
                .build();
    }

    private LightingDevice buildLightingDevice(String lightingDeviceName, double illuminanceOfLightingDevice) {
        return LightingDevice.LightingDeviceBuilder.create()
                .withLightingDeviceName(lightingDeviceName)
                .withIlluminanceOfLightingDevice(illuminanceOfLightingDevice)
                .build();
    }
}
