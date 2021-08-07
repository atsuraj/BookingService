package com.paypal.bfs.test.bookingserv.common.exception;

public class BookingAlreadyExistException extends RuntimeException{

    public BookingAlreadyExistException(String message){
        super(message);
    }
    public BookingAlreadyExistException(String message, Throwable error){
        super(message,error);
    }
}
