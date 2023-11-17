package com.restapi.controller;

import com.restapi.model.Cruise;
import com.restapi.model.Role;
import com.restapi.response.common.APIResponse;
import com.restapi.service.CruiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/cruises")
@RolesAllowed(Role.USER)
public class CruiseController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private CruiseService cruiseService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllCruise() {
        List<Cruise> cruiseList = cruiseService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(cruiseList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
