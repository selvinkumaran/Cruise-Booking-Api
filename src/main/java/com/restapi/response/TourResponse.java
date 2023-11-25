package com.restapi.response;

import com.restapi.model.Tour;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

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
