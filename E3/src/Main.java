import Controller.BookingController;
import Entity.Booking;
import Entity.Customer;
import Entity.Room;
import Entity.RoomType;
import Service.BookingService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Booking> bookings = new ArrayList<>();

        BookingService bookingService = new BookingService(bookings);
        BookingController bookingController = new BookingController(bookingService);

        rooms.add(new Room(1, "RS001", RoomType.S, 8.0));
        rooms.add(new Room(2, "RD001", RoomType.D, 12.0));
        rooms.add(new Room(3, "RQ002", RoomType.Q, 35.0));
        rooms.add(new Room(4, "RT001", RoomType.T, 12.5));
        rooms.add(new Room(5, "RQ001", RoomType.QU, 20.5));

        customers.add(new Customer(1, "Mr.Linus Torvald", "84125325346457"));
        customers.add(new Customer(2, "Mr.Bill", "91124235346467"));
        customers.add(new Customer(3, "Mr.Turing", "911423534646"));


        bookings.add(new Booking(1, rooms.get(0), customers.get(0),
                LocalDateTime.of(2023, 3, 15, 9, 30, 15),
                LocalDateTime.of(2023, 3, 16, 12, 30, 45)));

        bookings.add(new Booking(2, rooms.get(0), customers.get(1),
                LocalDateTime.of(2023, 6, 9, 19, 30, 25),
                LocalDateTime.of(2023, 6, 10, 11, 25, 15)));

        bookings.add(new Booking(3, rooms.get(1), customers.get(1),
                LocalDateTime.of(2023, 3, 11, 10, 10, 5),
                LocalDateTime.of(2023, 3, 13, 11, 5, 10)));

        bookings.add(new Booking(4, rooms.get(3), customers.get(2),
                LocalDateTime.of(2023, 11, 11, 11, 11, 15),
                LocalDateTime.of(2023, 11, 13, 11, 15, 15)));

        bookings.add(new Booking(5, rooms.get(3), customers.get(0),
                LocalDateTime.of(2023, 10, 25, 9, 20, 25),
                LocalDateTime.of(2023, 10, 26, 12, 25, 30)));

        bookings.add(new Booking(6, rooms.get(4), customers.get(0),
                LocalDateTime.of(2023, 8, 18, 18, 25, 35),
                LocalDateTime.of(2023, 8, 19, 11, 35, 20)));


        Booking foundBooking = bookingController.findBookingByCustomerInfo("Mr.Linus Torvald", "84125325346457", "RS001");
        if (foundBooking != null) {
            System.out.println("Booking Found: " + foundBooking);
        } else {
            System.out.println("No booking found for the given customer info.");
        }

        Map<RoomType, Double> revenueByRoomType = bookingController.getRevenueByRoomType();
        System.out.println(revenueByRoomType);

        Map<RoomType, Double> topRevenueRoomType2023 = bookingController.getTopRevenueRoomType2023();
        System.out.println(topRevenueRoomType2023);
    }
}
