package com.restapi.repository;

import com.restapi.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("select b from Booking b inner join b.appUser a where a.id=?1")
    Optional<List<Booking>> findUserBooking(Long userId);

}

