package by.makhon.buildingdesigner.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room {

    private int roomId;
    private String roomName;
    private double roomArea;
    private int windowsAmount;
    private List<RoomItem> roomItems = new ArrayList<>();
    private List<LightingDevice> lightingDevices = new ArrayList<>();

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(double roomArea) {
        this.roomArea = roomArea;
    }

    public int getWindowsAmount() {
        return windowsAmount;
    }

    public void setWindowsAmount(int windowsAmount) {
        this.windowsAmount = windowsAmount;
    }

    public List<RoomItem> getRoomItems() {
        return roomItems;
    }

    public void setRoomItems(List<RoomItem> roomItems) {
        this.roomItems = roomItems;
    }

    public List<LightingDevice> getLightingDevices() {
        return lightingDevices;
    }

    public void setLightingDevices(List<LightingDevice> lightingDevices) {
        this.lightingDevices = lightingDevices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomId == room.roomId &&
                Double.compare(room.roomArea, roomArea) == 0 &&
                windowsAmount == room.windowsAmount &&
                Objects.equals(roomName, room.roomName) &&
                Objects.equals(roomItems, room.roomItems) &&
                Objects.equals(lightingDevices, room.lightingDevices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, roomName, roomArea, windowsAmount, roomItems, lightingDevices);
    }

    public double getSummaryItemArea() {
        double summaryItemArea = 0.0;
        for (RoomItem roomItem : roomItems) {
            summaryItemArea +=  (roomItem.getMaxRoomItemArea() + roomItem.getMinRoomItemArea()) / 2;
        }
        return summaryItemArea;
    }

    public double getFreeRoomArea() {
        double freeRoomArea = 0.0;
        for (RoomItem roomItem : roomItems) {
            freeRoomArea += (roomItem.getMaxRoomItemArea() + roomItem.getMinRoomItemArea()) / 2;
        }
        return roomArea - freeRoomArea;
    }

    public double getSummaryIlluminance() {
        double summaryIlluminanceOfLightingDevices = 0.0;
        double summaryIlluminanceOfWindows = 0.0;
        for (LightingDevice lightingDevice : lightingDevices) {
            summaryIlluminanceOfLightingDevices += lightingDevice.getIlluminanceOfLightingDevice();
        }

        if ( windowsAmount > 0 ) {
           summaryIlluminanceOfWindows = windowsAmount * 700;
        }

        return summaryIlluminanceOfLightingDevices + summaryIlluminanceOfWindows;
    }

    public double getPercentageOfUsingArea() {
        return Math.round(getSummaryItemArea()*100/roomArea);
    }

    public double getPercentageOfFreeArea() {
        return Math.round(getFreeRoomArea()*100/roomArea);
    }

    public void addRoomItem(RoomItem roomItem) {
        roomItems.add(roomItem);
    }

    public void addLightingDevice(LightingDevice lightingDevice) {
        lightingDevices.add(lightingDevice);
    }

    public void describe() {
        System.out.println("\n\t" + getRoomName() + "\n" + "\n\t\tRoom area = " + getRoomArea() + " m2");
        System.out.println("\t\tFree room area = " + getFreeRoomArea() + " m2. Or " + getPercentageOfFreeArea() + "% of free space");

        if (roomItems.isEmpty()) {
            System.out.println("\t\tFurniture: there are no furniture in this room");
        } else {
            System.out.println("\t\tFurniture: ");
            for (RoomItem roomItem : roomItems) {
                if (roomItem.getMinRoomItemArea() == 0.0 || roomItem.getMinRoomItemArea() < 0.0){
                    System.out.println("\t\t\t" + roomItem.getRoomItemName() + " (area = " +
                            roomItem.getMaxRoomItemArea() + " m2)");
                }
                if (roomItem.getMaxRoomItemArea() == 0.0 || roomItem.getMaxRoomItemArea() < 0.0) {
                    System.out.println("\t\t\t" + roomItem.getRoomItemName() + " (area = " +
                            roomItem.getMinRoomItemArea() + " m2)");
                } else {
                    System.out.println("\t\t\t" + roomItem.getRoomItemName() + " (area = " + "from " +
                            roomItem.getMinRoomItemArea() + " to " + roomItem.getMaxRoomItemArea() + " m2)");
                }
            }
        }

        System.out.println("\t\tIlluminance = " + getSummaryIlluminance() + " lux:");
        if (windowsAmount > 1) {
            System.out.println("\t\t\t" + windowsAmount + " windows with illuminance of 700.0 lux for each window");
        } else if (windowsAmount == 1) {
            System.out.println("\t\t\t" + windowsAmount + " window with illuminance of 700.0");
        } else if (windowsAmount < 0) {
            System.out.println("\t\t\tIncorrect amount of windows: " + windowsAmount);
        }

        if (lightingDevices.isEmpty()) {
            System.out.println("\t\t\tIn this room no lighting devices.");
        } else {
            for (LightingDevice lightingDevice : lightingDevices) {
                System.out.println("\t\t\t" + lightingDevice.getLightingDeviceName() + " with illuminance of " +
                        lightingDevice.getIlluminanceOfLightingDevice() + " lux");
            }
        }
    }

    public static class RoomBuilder {
        private Room room = new Room();

        public static RoomBuilder create() {
            return new RoomBuilder();
        }

        public RoomBuilder withRoomId(int roomId) {
            room.roomId = roomId;
            return this;
        }

        public RoomBuilder withRoomName(String roomName) {
            room.roomName = roomName;
            return this;
        }

        public RoomBuilder withRoomArea(double roomArea) {
            room.roomArea = roomArea;
            return this;
        }

        public RoomBuilder withWindowsAmount(int windowsAmount) {
            room.windowsAmount = windowsAmount;
            return this;
        }

        public RoomBuilder withRoomItems(List roomItems) {
            room.roomItems = roomItems;
            return this;
        }

        public RoomBuilder withLightingDevice(List lightingDevices) {
            room.lightingDevices = lightingDevices;
            return this;
        }

        public Room build() {
            return room;
        }
    }
}
