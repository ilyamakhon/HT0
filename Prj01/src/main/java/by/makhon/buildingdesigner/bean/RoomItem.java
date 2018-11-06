package by.makhon.buildingdesigner.bean;

import java.util.Objects;

public class RoomItem {

    private String name;
    private double minArea;
    private double maxArea;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinArea() {
        return minArea;
    }

    public void setMinArea(double minArea) {
        this.minArea = minArea;
    }

    public double getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(double maxArea) {
        this.maxArea = maxArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomItem roomItem = (RoomItem) o;
        return Double.compare(roomItem.minArea, minArea) == 0 &&
                Double.compare(roomItem.maxArea, maxArea) == 0 &&
                Objects.equals(name, roomItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, minArea, maxArea);
    }

    public static class RoomItemBuilder {
        private RoomItem roomItem = new RoomItem();

        public static RoomItemBuilder create() {
            return new RoomItemBuilder();
        }

        public RoomItemBuilder withRoomItemName(String roomItemName) {
            roomItem.name = roomItemName;
            return this;
        }

        public RoomItemBuilder withMinRoomItemArea(double minRoomItemArea) {
            roomItem.minArea = minRoomItemArea;
            return this;
        }

        public RoomItemBuilder withMaxRoomItemArea(double maxRoomItemArea) {
            roomItem.maxArea = maxRoomItemArea;
            return this;
        }

        public RoomItem build() {
            return roomItem;
        }
    }
}
