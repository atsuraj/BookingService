package com.paypal.bfs.test.bookingserv.convertor;

import com.paypal.bfs.test.bookingserv.model.AddressEntity;
import com.paypal.bfs.test.bookingserv.model.BookingEntity;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public final class EntityToDaoConvertor {

    private EntityToDaoConvertor() {
    }

    public static BookingEntity convertEntityToBookingEntity(Booking booking){
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setFirstName(booking.getFirstName());
        bookingEntity.setLastName(booking.getLastName());
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            bookingEntity.setDateOfBirth(dateFormat.parse(booking.getDateOfBirth()));
            bookingEntity.setCheckedIn(dateFormat.parse(booking.getCheckedIn()));
            bookingEntity.setCheckedOut(dateFormat.parse(booking.getCheckedOut()));
            bookingEntity.setTotalPrice((Double) booking.getTotalPrice());
            bookingEntity.setDeposit((Double) booking.getDeposit());
        }catch (ParseException e){
           throw new RuntimeException(e.getMessage());
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        bookingEntity.setAddressEntity(convertEntityToAddressEntity(booking.getAddress()));
        return bookingEntity;
    }
    public static AddressEntity convertEntityToAddressEntity(Address address){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity(address.getCity());
        addressEntity.setCountry(address.getCountry());
        addressEntity.setState(address.getState());
        addressEntity.setZipcode(address.getZipcode());
        addressEntity.setLine1(address.getLine1());
        addressEntity.setLine2(address.getLine2());
        return addressEntity;
    }
}
