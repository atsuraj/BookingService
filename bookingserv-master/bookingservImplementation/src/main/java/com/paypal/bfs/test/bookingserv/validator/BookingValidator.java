package com.paypal.bfs.test.bookingserv.validator;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

public class BookingValidator {


    public static   void validateBooking(Booking booking) {
        if(booking.getFirstName()==null) throw new RuntimeException("First Name field is expected in request.");
        if(booking.getDateOfBirth()==null) throw new RuntimeException("Date of Birth field is expected in request.");
        if(booking.getCheckedIn()==null) throw new RuntimeException("CheckedIn Date field is expected in request.");
        if(booking.getCheckedOut()==null) throw new RuntimeException("CheckedOut Date field is expected in request.");
        if(booking.getTotalPrice()==null){
            throw new RuntimeException("Total Price field is expected in request.");
        }else{
            if(booking.getTotalPrice() instanceof Integer){
                int i = (int) booking.getTotalPrice();
                double d = i;
                booking.setTotalPrice(d);
            }else if(!(booking.getTotalPrice() instanceof Double)){
                throw new RuntimeException("Invalid Total Price.");
            }
        }
        if(booking.getDeposit()==null){
            throw new RuntimeException("Deposit field is expected in request.");
        }else{
            if(booking.getDeposit() instanceof Integer){
                int i = (int) booking.getDeposit();
                double d = i;
                booking.setDeposit(d);
            }else if(!(booking.getDeposit() instanceof Double)){
                throw new RuntimeException("Invalid Total Price.");
            }
        }
        if(booking.getAddress()==null) throw new RuntimeException("Address is expected in request.");
        AddressValidator.validateAddress(booking.getAddress());
    }
}
