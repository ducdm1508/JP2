package Controller;

import Entity.Booking;
import Entity.Customer;
import Entity.Room;
import Entity.RoomType;
import Service.BookingService;
import Service.CustomerService;
import Service.RoomService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class BookingController {

    private BookingService bookingService;
    private RoomService roomService;
    private CustomerService customerService;

    public BookingController(BookingService bookingService, RoomService roomService, CustomerService customerService) {
        this.bookingService = bookingService;
        this.roomService = roomService;
        this.customerService = customerService;
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

    public void createBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Room Type (Single, Double, Queen, Quad, Triple): ");
        String roomTypeInput = scanner.nextLine();

        List<Room> availableRooms = roomService.getRoomByType(roomTypeInput);

        if (availableRooms.size() == 0) {
            System.out.println("There are no rooms of this type.");
            return;
        } else {
            System.out.println("List of Available Rooms:");
            availableRooms.forEach(room -> System.out.println(room));
        }

        System.out.println("Enter Room Code: ");
        String roomCode = scanner.nextLine();
        Optional<Room> roomOptional = roomService.getRoomByCode(roomCode);

        if (roomOptional.isPresent()) {
            roomOptional.get();
        }else {
            System.out.println("Room not found");
            return;
        }

        Room room = roomOptional.get();
        if (!room.getRoomType().getType().equalsIgnoreCase(roomTypeInput)) {
            System.out.println("The selected room does not belong to the specified room type.");
            return;
        }

        Optional<Booking> bookingOptional = bookingService.findBookingByRoomCode(roomCode);
        if (bookingOptional.isPresent()) {
            System.out.println("The room has already been booked.");
            return;
        }

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer phone: ");
        String customerPhone = scanner.nextLine();
        System.out.print("Enter check-in date and time (YYYY-MM-DDTHH:MM): ");
        LocalDateTime checkInDateTime = LocalDateTime.parse(scanner.nextLine());
        System.out.print("Enter check-out date and time (YYYY-MM-DDTHH:MM): ");
        LocalDateTime checkOutDateTime = LocalDateTime.parse(scanner.nextLine());

        Customer customer = new Customer(customerService.getNextId(), customerName, customerPhone);
        Booking newBooking = new Booking(0, room, customer, checkInDateTime, checkOutDateTime);
        bookingService.add(newBooking);
        System.out.println("Booking successful!");
        System.out.println(newBooking);
    }
}
