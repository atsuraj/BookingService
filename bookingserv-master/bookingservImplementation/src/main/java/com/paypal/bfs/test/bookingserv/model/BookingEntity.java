package com.paypal.bfs.test.bookingserv.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity(name = "booking")
@Data
public class BookingEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "First Name cannot be null")
    @JsonProperty("first_name")
    @JsonPropertyDescription("First name")
    @Size(min = 1,max = 255)
    @Column(name = "first_name")
    private String firstName;

    @JsonProperty("last_name")
    @JsonPropertyDescription("Last name")
    @Size(min = 1,max = 255)
    @Column(name = "last_name")
    private String lastName;

    @JsonPropertyDescription("Date of Birth")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @NotNull(message = "CheckedIn Date cannot be null")
    @Column(name = "checked_in")
    private Date checkedIn;

    @NotNull(message = "CheckedOut Date cannot be null")
    @Column(name = "checked_out")
    private Date checkedOut;


    @NotNull(message = "Total price cannot be null")
    @JsonProperty("total_price")
    @JsonPropertyDescription("Total Price")
    @Column(name = "total_price")
    private double totalPrice;

    @NotNull(message = "Deposit cannot be null")
    @JsonProperty("deposit")
    @JsonPropertyDescription("Deposit")
    @Column(name = "deposit")
    private double deposit;

    @NotNull(message = "Address cannot be null")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity addressEntity;

}
