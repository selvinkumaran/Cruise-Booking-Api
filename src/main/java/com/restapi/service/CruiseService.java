package com.restapi.service;

import com.restapi.dto.CruiseDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Cruise;
import com.restapi.repository.CruiseRepository;
import com.restapi.request.CruiseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CruiseService {

    @Autowired
    private CruiseRepository cruiseRepository;

    @Autowired
    private CruiseDto cruiseDto;

    @Autowired
    private StorageService storageService;

    public List<Cruise> findAll() {
        return cruiseRepository.findAll();
    }

    public List<Cruise> create(CruiseRequest cruiseRequest) {
        Cruise cruise = cruiseDto.mapToCruise(cruiseRequest);
        cruiseRepository.save(cruise);
        return findAll();
    }

    public List<Cruise> update(CruiseRequest cruiseRequest) {
        Cruise cruise = cruiseDto.mapToCruise(cruiseRequest);
        cruiseRepository.save(cruise);
        return findAll();
    }

    public List<Cruise> deleteById(Long id) {
        cruiseRepository.deleteById(id);
        return findAll();
    }

    public Cruise findCruiseById(Long id) {
        return cruiseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("cruise", "id", id));
    }

    public File getFile(Long id) throws IOException {
        Cruise cruise = cruiseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id", "id", id));

        Resource resource = storageService.loadFileAsResource(cruise.getPhoto());

        return resource.getFile();
    }

}
