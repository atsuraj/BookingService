package com.paypal.bfs.test.bookingserv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class ExceptionResponse {


    private String message;
    private String description;
    private Date timeStamp;

}
