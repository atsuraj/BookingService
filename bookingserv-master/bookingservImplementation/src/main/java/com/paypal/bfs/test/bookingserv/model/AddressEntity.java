package com.paypal.bfs.test.bookingserv.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity(name = "address")
@Data
public class AddressEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Line1 Address cannot be null")
    @Column(name = "line1")
    private String line1;

    @Column(name = "line2")
    private String line2;

    @NotNull(message = "City cannot be null")
    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @NotNull(message = "Country cannot be null")
    @Column(name = "country")
    private String country;

    @NotNull(message = "Zipcode cannot be null")
    @JsonPropertyDescription("Zipcode")
    @Pattern(regexp = "^[1-9][0-9]{5}$")
    @Column(name = "zipcode")
    private String zipcode;
}
