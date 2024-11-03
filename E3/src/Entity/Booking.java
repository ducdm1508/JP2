package Entity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Booking {
    private int id;
    private Room room;
    private Customer customer;
    private LocalDateTime checkInDateTime;
    private LocalDateTime checkOutDateTime;

    public Booking() {;}

    public Booking(int id, Room room, Customer customer, LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime) {
        this.id = id;
        this.room = room;
        this.customer = customer;
        this.checkInDateTime = checkInDateTime;
        this.checkOutDateTime = checkOutDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getCheckInDateTime() {
        return checkInDateTime;
    }

    public void setCheckInDateTime(LocalDateTime checkInDateTime) {
        this.checkInDateTime = checkInDateTime;
    }

    public LocalDateTime getCheckOutDateTime() {
        return checkOutDateTime;
    }

    public void setCheckOutDateTime(LocalDateTime checkOutDateTime) {
        this.checkOutDateTime = checkOutDateTime;
    }

    public double getHourBooked(){
        return checkInDateTime.until(checkOutDateTime, ChronoUnit.HOURS);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", room=" + room.getCode() +
                ", customer=" + customer.getId() +
                ", checkInDateTime=" + checkInDateTime +
                ", checkOutDateTime=" + checkOutDateTime +
                '}';
    }
}
