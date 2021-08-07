package com.paypal.bfs.test.bookingserv.repository;

import com.paypal.bfs.test.bookingserv.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Integer> {
    Optional<BookingEntity> findByFirstNameAndLastName(String firstName, String lastName);
}
