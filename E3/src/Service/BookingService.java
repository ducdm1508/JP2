package Service;

import Entity.Booking;
import Entity.Customer;
import Entity.RoomType;
import iGeneral.IGeneral;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingService implements IGeneral<Booking> {
    private List<Booking> bookings;

    public BookingService(List<Booking> bookings){
        this.bookings = bookings;
    }

    public Booking findBookingByCustomerInfo(String customerName, String customerPhone, String roomId) {
        Optional<Booking> found = bookings.stream()
                .filter(bk -> bk.getCustomer().getName().contains(customerName) &&
                        bk.getCustomer().getPhone().equals(customerPhone) && bk.getRoom().getCode().equals(roomId))
                .findFirst();
        return found.orElse(null);
    }

    @Override
    public Map<RoomType, Double> calculateRevenueByRoomType() {

        Map<RoomType, Double> revenueByRoomType = new HashMap<>();

        bookings.stream()
                .filter(booking -> booking.getRoom() != null)
                .forEach(booking -> {
                    RoomType roomType = booking.getRoom().getRoomType();
                    double revenue = booking.getHourBooked() * booking.getRoom().getPricePerHour();


                    revenueByRoomType.put(roomType, revenueByRoomType.getOrDefault(roomType, 0.0) + revenue);
                });

        return revenueByRoomType;
    }

    @Override
    public Map<RoomType, Double> getTopRevenueRoomType2023() {
        Map<RoomType, Double> revenueByRoomType = new HashMap<>();
        bookings.stream()
                .filter(booking -> booking.getCheckInDateTime().getYear() == 2023)
                .forEach(booking -> {
                    RoomType roomType = booking.getRoom().getRoomType();
                    double revenue = booking.getHourBooked() * booking.getRoom().getPricePerHour();


                    revenueByRoomType.put(roomType, revenueByRoomType.getOrDefault(roomType, 0.0) + revenue);
                });
        return revenueByRoomType;
    }


}
