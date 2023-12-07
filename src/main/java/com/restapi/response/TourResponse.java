package com.restapi.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TourResponse {

    private Long id;

    private Long cruiseId;

    private String cruiseName;

    private String cruiseCapacity;

    private String cruiseDescription;

    private String cruisePhoto;

    private Double price;

    private String checkInDate;

    private String checkOutDate;

    private String destination;

    private int balance;

}
