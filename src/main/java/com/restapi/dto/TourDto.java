package com.restapi.dto;

import com.restapi.model.Tour;
import com.restapi.request.TourRequest;
import org.springframework.stereotype.Component;

@Component
public class TourDto {
    public Tour mapToTour(TourRequest tourRequest) {
        Tour tour = new Tour();
        if (tourRequest.getId() != null) {
            tour.setId(tourRequest.getId());
        }
        tour.setCheckInDate(tourRequest.getCheckInDate());
        tour.setCheckOutDate(tourRequest.getCheckOutDate());
        tour.setBalance(tourRequest.getBalance());
        tour.setDestination(tourRequest.getDestination());
        tour.setPrice(tourRequest.getPrice());

        return tour;
    }
}
