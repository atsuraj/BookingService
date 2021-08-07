package com.paypal.bfs.test.bookingserv.convertor;

import com.paypal.bfs.test.bookingserv.model.AddressEntity;
import com.paypal.bfs.test.bookingserv.model.BookingEntity;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public final class DaoToEntityConvertor {

    private DaoToEntityConvertor() {
    }

    public static Booking convertDAOToBooking(BookingEntity bookingEntity){
        Booking booking = new Booking();
        booking.setId(bookingEntity.getId());
        booking.setFirstName(bookingEntity.getFirstName());
        booking.setLastName(bookingEntity.getLastName());
        try{
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = dateFormat.format(bookingEntity.getDateOfBirth());
            booking.setDateOfBirth(strDate);
            booking.setCheckedIn(dateFormat.format(bookingEntity.getCheckedIn()));
            booking.setCheckedOut(dateFormat.format(bookingEntity.getCheckedOut()));
            booking.setTotalPrice(bookingEntity.getTotalPrice());
            booking.setDeposit(bookingEntity.getDeposit());
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
        booking.setAddress(convertDAOToAddress(bookingEntity.getAddressEntity()));
        return booking;
    }

    public static Address convertDAOToAddress(AddressEntity addressEntity){
        Address address = new Address();
        address.setLine1(addressEntity.getLine1());
        address.setLine2(addressEntity.getLine2());
        address.setCity(addressEntity.getCity());
        address.setState(addressEntity.getState());
        address.setCountry(addressEntity.getCountry());
        address.setZipcode(addressEntity.getZipcode());
        return address;
    }
}
