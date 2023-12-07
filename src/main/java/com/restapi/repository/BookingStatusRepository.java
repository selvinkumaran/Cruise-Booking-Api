package com.restapi.repository;

import com.restapi.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingStatusRepository extends JpaRepository<BookingStatus, Long> {
    List<BookingStatus> findByStatus(String status);

}
