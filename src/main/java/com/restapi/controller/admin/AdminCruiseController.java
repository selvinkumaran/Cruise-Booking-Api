package com.restapi.controller.admin;

import com.restapi.model.Cruise;
import com.restapi.model.Role;
import com.restapi.request.CruiseRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.CruiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/cruises")
@RolesAllowed(Role.ADMIN)
public class AdminCruiseController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private CruiseService cruiseService;

    @GetMapping("/{cruiseId}")
    public ResponseEntity<APIResponse> getCruiseDetails(@PathVariable Long cruiseId) {
        Cruise cruise = cruiseService.findCruiseById(cruiseId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(cruise);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse> createCruise(@Valid @RequestBody
                                                    CruiseRequest cruiseRequest) {
        List<Cruise> cruiseResponse = cruiseService.create(cruiseRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(cruiseResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateCruise(@Valid @RequestBody
                                                    CruiseRequest cruiseRequest) {
        List<Cruise> cruiseResponse = cruiseService.update(cruiseRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(cruiseResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteCruise(@PathVariable Long id) {
        List<Cruise> cruiseResponse = cruiseService
                .deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(cruiseResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
