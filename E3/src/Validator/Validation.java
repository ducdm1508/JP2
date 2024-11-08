package Validator;

import java.time.LocalDateTime;

public class Validation {

    public static boolean isCheckIn(LocalDateTime checkIn){
        return checkIn.isAfter(LocalDateTime.now());
    }

    public static boolean isCheckOut(LocalDateTime checkIn, LocalDateTime checkOut){
        return checkOut.isAfter(checkIn);
    }
}
