package com.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "paymentId")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "tourId")
    private Tour tour;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime bookingDate;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private BookingStatus bookingStatus;

}
