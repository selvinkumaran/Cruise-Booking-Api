package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "bookingStatus")
    private List<Booking> bookingList;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public BookingStatus(String status) {
        this.status = status;
    }
}
