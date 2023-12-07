package com.restapi.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cruise_id", referencedColumnName = "id")
    private Cruise cruise;

    private Double price;

    private String CheckInDate;

    private String CheckOutDate;

    private String destination;

    private int balance;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
