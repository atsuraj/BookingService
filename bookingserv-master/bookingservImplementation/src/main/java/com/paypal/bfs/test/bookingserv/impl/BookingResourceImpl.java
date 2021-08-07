package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResources;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.common.exception.BookingAlreadyExistException;
import com.paypal.bfs.test.bookingserv.common.exception.BookingNotFoundException;
import com.paypal.bfs.test.bookingserv.model.BookingEntity;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.validator.BookingValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.paypal.bfs.test.bookingserv.convertor.EntityToDaoConvertor.convertEntityToBookingEntity;
import static com.paypal.bfs.test.bookingserv.convertor.DaoToEntityConvertor.convertDAOToBooking;
import static com.paypal.bfs.test.bookingserv.convertor.DaoToEntityConvertor.convertDAOToAddress;
import static com.paypal.bfs.test.bookingserv.convertor.EntityToDaoConvertor.convertEntityToAddressEntity;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@RestController
public class BookingResourceImpl implements BookingResources{

    @Autowired
    BookingRepository bookingRepository;



    @Override
    public ResponseEntity<Booking> create(@Valid  Booking booking) {

        Optional<Booking> optionalBooking = Optional.of(booking);
        if(optionalBooking.isPresent()){
            BookingValidator.validateBooking(booking);
        }else{
            throw new RuntimeException("Invalid Request");
        }


        BookingEntity bookingEntity = convertEntityToBookingEntity(booking);
        checkIfIsExistingBooking(bookingEntity);

        bookingRepository.save(bookingEntity);
        return new ResponseEntity<Booking>(HttpStatus.CREATED);
    }

    private void checkIfIsExistingBooking(BookingEntity bookingEntity) {
        Optional<BookingEntity> bookingEntityOptional = bookingRepository.findByFirstNameAndLastName(bookingEntity.getFirstName(), bookingEntity.getLastName());
        if(bookingEntityOptional.isPresent()){
            throw new BookingAlreadyExistException("Booking already exist for user: "+ bookingEntity.getFirstName()
                    +" "+ bookingEntity.getLastName());
        }
    }

    @Override
    public ResponseEntity<List<Booking>> retrieve() {
        Optional<List<BookingEntity>> bookingEntityList = Optional.of(bookingRepository.findAll());

        if(!bookingEntityList.isPresent()  || bookingEntityList.get().size()==0){
            throw new BookingNotFoundException("Failed to Retrieve");
        }
        List<Booking> bookingList = new ArrayList();
        for (int i = 0; i < bookingEntityList.get().size(); i++) {
            BookingEntity bookingEntity = bookingEntityList.get().get(i);
            bookingList.add(convertDAOToBooking(bookingEntity));
        }


        return new ResponseEntity<List<Booking>>(bookingList,HttpStatus.OK);
    }
}
