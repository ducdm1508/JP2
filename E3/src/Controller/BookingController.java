package Controller;

import Entity.Booking;
import Entity.RoomType;
import Service.BookingService;

import java.util.Map;
import java.util.Optional;

public class BookingController {

    private BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public Booking findBookingByCustomerInfo(String customerName, String customerPhone, String roomId) {

        return bookingService.findBookingByCustomerInfo(customerName, customerPhone, roomId);
    }
    public Map<RoomType, Double> getRevenueByRoomType() {
        return bookingService.calculateRevenueByRoomType();
    }

    public Map<RoomType, Double> getTopRevenueRoomType2023() {
        return bookingService.getTopRevenueRoomType2023();
    }
}
