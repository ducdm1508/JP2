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
        Map<RoomType, Double> revenueByRoomType = bookings.stream()
                .collect(Collectors.groupingBy(
                        booking -> booking.getRoom().getRoomType(),
                        Collectors.summingDouble(booking -> booking.getHourBooked() * booking.getRoom().getPricePerHour())
                ));
        return revenueByRoomType;
    }

    @Override
    public Map<RoomType, Double> getTopRevenueRoomType2023() {

        Map<RoomType, Double> revenueByRoomType = bookings.stream()
                .filter(booking -> booking.getCheckInDateTime().getYear() == 2023)
                .collect(Collectors.groupingBy(
                        booking -> booking.getRoom().getRoomType(),
                        Collectors.summingDouble(booking -> booking.getHourBooked() * booking.getRoom().getPricePerHour())
                ));

        Optional<Map.Entry<RoomType, Double>> topRevenueRoomType = revenueByRoomType.entrySet().stream()
                .collect(Collectors.maxBy(Map.Entry.comparingByValue()));

        return topRevenueRoomType.map(entry -> Map.of(entry.getKey(), entry.getValue()))
                .orElseGet(HashMap::new);
    }


}
