
package com.restapi.repository;

import com.restapi.model.Booking;
import com.restapi.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingStatusRepository extends JpaRepository<BookingStatus,Long> {

    List<BookingStatus> findByStatus(String status);
}
