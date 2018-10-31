package by.makhon.buildingdesigner.bean;

import java.util.Objects;

public class RoomItem {

    private int roomItemId;
    private String roomItemName;
    private double minRoomItemArea;
    private double maxRoomItemArea;


    public int getRoomItemId() {
        return roomItemId;
    }

    public void setRoomItemId(int roomItemId) {
        this.roomItemId = roomItemId;
    }

    public String getRoomItemName() {
        return roomItemName;
    }

    public void setRoomItemName(String roomItemName) {
        this.roomItemName = roomItemName;
    }

    public double getMinRoomItemArea() {
        return minRoomItemArea;
    }

    public void setMinRoomItemArea(double minRoomItemArea) {
        this.minRoomItemArea = minRoomItemArea;
    }

    public double getMaxRoomItemArea() {
        return maxRoomItemArea;
    }

    public void setMaxRoomItemArea(double maxRoomItemArea) {
        this.maxRoomItemArea = maxRoomItemArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomItem roomItem = (RoomItem) o;
        return roomItemId == roomItem.roomItemId &&
                Double.compare(roomItem.minRoomItemArea, minRoomItemArea) == 0 &&
                Double.compare(roomItem.maxRoomItemArea, maxRoomItemArea) == 0 &&
                Objects.equals(roomItemName, roomItem.roomItemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomItemId, roomItemName, minRoomItemArea, maxRoomItemArea);
    }

    public static class RoomItemBuilder {
        private RoomItem roomItem = new RoomItem();

        public static RoomItemBuilder create() {
            return new RoomItemBuilder();
        }

        public RoomItemBuilder withRoomItemName(String roomItemName) {
            roomItem.roomItemName = roomItemName;
            return this;
        }

        public RoomItemBuilder withMinRoomItemArea(double minRoomItemArea) {
            roomItem.minRoomItemArea = minRoomItemArea;
            return this;
        }

        public RoomItemBuilder withMaxRoomItemArea(double maxRoomItemArea) {
            roomItem.maxRoomItemArea = maxRoomItemArea;
            return this;
        }

        public RoomItem build() {
            return roomItem;
        }
    }
}
