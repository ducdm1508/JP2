package iGeneral;

import Entity.Booking;
import Entity.RoomType;

import java.util.List;
import java.util.Map;

public interface IGeneral<T> {
    Map<RoomType, Double> calculateRevenueByRoomType();
    Map<RoomType, Double> getTopRevenueRoomType2023();
}
