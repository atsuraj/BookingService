package com.paypal.bfs.test.bookingserv.validator;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;

public class AddressValidator {

    public static   void validateAddress(Address address) {
        if(address.getLine1()==null) throw new RuntimeException("Line1 field of address is expected in request.");
        if(address.getCity()==null) throw new RuntimeException("City field of address is expected in request.");
        if(address.getCountry()==null) throw new RuntimeException("Country field of address is expected in request.");
        if(address.getZipcode()==null) throw new RuntimeException("Zipcode field of address is expected in request.");

    }
}
