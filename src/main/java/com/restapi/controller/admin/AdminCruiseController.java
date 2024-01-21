package com.restapi.controller.admin;

import com.restapi.model.Cruise;
import com.restapi.model.Role;
import com.restapi.request.CruiseRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.CruiseService;
import com.restapi.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin/cruises")
@RolesAllowed(Role.ADMIN)
public class AdminCruiseController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private CruiseService cruiseService;

    @Autowired
    private StorageService storageService;

    @GetMapping("/{cruiseId}")
    public ResponseEntity<APIResponse> getCruiseDetails(@PathVariable Long cruiseId) {
        Cruise cruise = cruiseService.findCruiseById(cruiseId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(cruise);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<APIResponse> createCruise(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("description") String description,
            @RequestParam("name") String name,
            @RequestParam("capacity") int capacity
    ) throws IOException {

        String file = storageService.storeFile(photo);
        CruiseRequest cruiseRequest = new CruiseRequest();
        cruiseRequest.setName(name);
        cruiseRequest.setCapacity(capacity);
        cruiseRequest.setPhoto(file);
        cruiseRequest.setDescription(description);

        List<Cruise> cruiseResponse = cruiseService.create(cruiseRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(cruiseResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<APIResponse> updateCruise(@RequestParam("photo") MultipartFile photo,
                                                    @RequestParam("id") Long id,
                                                    @RequestParam("description") String description,
                                                    @RequestParam("name") String name,
                                                    @RequestParam("capacity") int capacity
    ) throws IOException {

        String file = storageService.storeFile(photo);
        CruiseRequest cruiseRequest = new CruiseRequest();
        cruiseRequest.setId(id);
        cruiseRequest.setName(name);
        cruiseRequest.setPhoto(file);
        cruiseRequest.setCapacity(capacity);
        cruiseRequest.setDescription(description);

        List<Cruise> cruiseResponse = cruiseService.update(cruiseRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(cruiseResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteCruise(@PathVariable Long id) {
        List<Cruise> cruiseResponse = cruiseService.deleteById(id);

        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(cruiseResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) throws IOException {

        File file = cruiseService.getFile(id);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
