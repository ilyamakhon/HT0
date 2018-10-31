package by.makhon.buildingdesigner.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Building {

    private int buildingId;
    private String buildingName;
    private List<Room> rooms = new ArrayList<>();

    public Building(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return buildingId == building.buildingId &&
                Objects.equals(buildingName, building.buildingName) &&
                Objects.equals(rooms, building.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildingId, buildingName, rooms);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoomByName(String roomName){
        for (Room room : rooms) {
            if (room.getRoomName().equals(roomName)) {
                return room;
            }
        }
        throw new NullPointerException("There is no room with name: " + roomName);
    }

    public Room getRoomById(int roomId){
        for (Room room : rooms) {
            if (room.getRoomId() == roomId) {
                return room;
            }
        }
        throw new NullPointerException("There is no room with id: " + roomId);
    }

    public void describe() {
        System.out.println("\n" + getBuildingName());
        for (Room room : rooms) {
            room.describe();
        }
    }
}
