package com.restapi.controller.admin;

import com.restapi.model.Role;
import com.restapi.model.Tour;
import com.restapi.request.TourRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/tour")
@RolesAllowed(Role.ADMIN)
public class AdminTourController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private TourService tourService;

    @GetMapping("/{tourId}")
    public ResponseEntity<APIResponse> getTourDetails(@PathVariable Long tourId) {
        Tour tour = tourService.findTourById(tourId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(tour);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse> createTour(@Valid @RequestBody
                                                  TourRequest tourRequest) {
        List<Tour> tourList = tourService.create(tourRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(tourList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateTour(@Valid @RequestBody
                                                  TourRequest tourRequest) {
        List<Tour> tourList = tourService.update(tourRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(tourList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteTour(@PathVariable Long id) {
        List<Tour> tourList = tourService
                .deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(tourList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
