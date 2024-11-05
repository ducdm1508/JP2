package Service;

import Entity.Room;

import java.util.List;
import java.util.Optional;

public class RoomService {
    private List<Room> rooms;
    public RoomService(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRoomByType(String type) {
        return rooms.stream()
                .filter(room -> room.getRoomType().getType().equalsIgnoreCase(type))
                .toList();
    }

    public Optional<Room> getRoomByCode(String code) {
        Optional<Room> roomCode = rooms.stream()
                .filter(room -> room.getCode().equals(code))
                .findFirst();
        return roomCode;
    }
}
