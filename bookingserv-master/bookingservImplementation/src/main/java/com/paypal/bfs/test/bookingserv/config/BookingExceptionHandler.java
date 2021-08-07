package com.paypal.bfs.test.bookingserv.config;

import com.paypal.bfs.test.bookingserv.common.exception.BookingNotFoundException;
import com.paypal.bfs.test.bookingserv.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.Date;
import java.util.List;

@RestController
@ControllerAdvice
public class BookingExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class,RuntimeException.class})
    @Nullable
    public final ResponseEntity<BookingNotFoundException> handleAllException(Exception ex, WebRequest request) throws Exception {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getLocalizedMessage(),request.getDescription(false),new Date());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({BookingNotFoundException.class})
    @Nullable
    public final ResponseEntity<BookingNotFoundException> handleBookingException(Exception ex, WebRequest request) throws Exception {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(),"Booking not find.",new Date());
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }



}
