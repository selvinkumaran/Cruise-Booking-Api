package com.restapi.service;

import com.restapi.dto.TourDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Cruise;
import com.restapi.model.Tour;
import com.restapi.repository.CruiseRepository;
import com.restapi.repository.TourRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.TourRequest;
import com.restapi.response.TourResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CruiseRepository cruiseRepository;

    @Autowired
    private TourDto tourDto;

    public List<Tour> findAll() {
        return tourRepository.findAll();
    }


    private void setCruise(Tour tour, Long cruiseId) {

        Cruise cruise = cruiseRepository.findById(cruiseId)
                .orElseThrow(() -> new ResourceNotFoundException("cruiseId", "cruiseId", cruiseId));

        tour.setCruise(cruise);
    }

    @Transactional
    public List<Tour> create(TourRequest tourRequest) {
        Tour tour = tourDto.mapToTour(tourRequest);
        setCruise(tour, tourRequest.getCruiseId());
        tourRepository.save(tour);
        return findAll();
    }

    @Transactional
    public List<Tour> update(TourRequest tourRequest) {
        Tour tour = tourDto.mapToTour(tourRequest);
        setCruise(tour, tourRequest.getCruiseId());
        tourRepository.save(tour);
        return findAll();
    }

    public List<Tour> deleteById(Long id) {
        tourRepository.deleteById(id);
        return findAll();
    }

    public Tour findTourById(Long id) {
        return tourRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("cruise", "id", id));
    }

    public List<TourResponse> getTourByCruiseId(Long cruiseId) {
        List<Tour> tours = tourRepository.findByCruiseId(cruiseId);
        return tours.stream()
                .map(this::convertToTourResponse)
                .collect(Collectors.toList());
    }

    private TourResponse convertToTourResponse(Tour tour) {
        TourResponse tourResponse = new TourResponse();
        tourResponse.setId(tour.getId());
        tourResponse.setBalance(tour.getBalance());
        tourResponse.setPrice(tour.getPrice());
        tourResponse.setCheckInDate(tour.getCheckInDate());
        tourResponse.setCheckOutDate(tour.getCheckOutDate());
        tourResponse.setCruiseName(tour.getCruise().getName());
        tourResponse.setCruiseCapacity(String.valueOf(tour.getCruise().getCapacity()));
        tourResponse.setDestination(tour.getDestination());
        tourResponse.setCruiseId(tourResponse.getCruiseId());
        tourResponse.setCruiseId(tour.getCruise().getId());
        tourResponse.setCruiseDescription(tour.getCruise().getDescription());
        tourResponse.setCruisePhoto(tour.getCruise().getPhoto());
        return tourResponse;
    }

}
