package com.restapi.controller;

import com.restapi.model.Role;
import com.restapi.model.Tour;
import com.restapi.response.TourResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/tours")
@RolesAllowed(Role.USER)
public class TourController {

    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private TourService tourService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllTours() {
        List<Tour> tourList = tourService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(tourList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/cruise/{cruiseId}")
    public ResponseEntity<APIResponse> getTourByCruiseId(@PathVariable Long cruiseId) {
        List<TourResponse> tourResponseList = tourService.getTourByCruiseId(cruiseId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(tourResponseList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}

