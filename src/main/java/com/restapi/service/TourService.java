package com.restapi.service;

import com.restapi.dto.TourDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.AppUser;
import com.restapi.model.Cruise;
import com.restapi.model.Tour;
import com.restapi.repository.CruiseRepository;
import com.restapi.repository.TourRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.TourRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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


    private void setAppUserAndCruise(Tour tour, Long userId, Long cruiseId) {
        AppUser appUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId", userId));

        Cruise cruise = cruiseRepository.findById(cruiseId)
                .orElseThrow(() -> new ResourceNotFoundException("cruiseId", "cruiseId", cruiseId));

        tour.setAppUser(appUser);
        tour.setCruise(cruise);
    }

    @Transactional
    public List<Tour> create(TourRequest tourRequest) {
        Tour tour = tourDto.mapToTour(tourRequest);
        setAppUserAndCruise(tour, tourRequest.getUserId(), tourRequest.getCruiseId());
        tourRepository.save(tour);
        return findAll();
    }

    @Transactional
    public List<Tour> update(TourRequest tourRequest) {
        Tour tour = tourDto.mapToTour(tourRequest);
        setAppUserAndCruise(tour, tourRequest.getUserId(), tourRequest.getCruiseId());
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
}
