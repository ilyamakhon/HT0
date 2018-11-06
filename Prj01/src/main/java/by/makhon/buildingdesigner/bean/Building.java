package by.makhon.buildingdesigner.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Building {

    private String name;
    private List<Room> rooms = new ArrayList<>();

    public Building(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Objects.equals(name, building.name) &&
                Objects.equals(rooms, building.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rooms);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoomByName(String roomName){
        for (Room room : rooms) {
            if (room.getName().equals(roomName)) {
                return room;
            }
        }
        throw new NullPointerException("There is no room with name: " + roomName);
    }

    public void describe() {
        System.out.println("\n" + getName());
        for (Room room : rooms) {
            room.describe();
        }
    }
}
