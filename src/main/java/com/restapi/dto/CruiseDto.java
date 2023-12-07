package com.restapi.dto;

import com.restapi.model.Cruise;
import com.restapi.request.CruiseRequest;
import org.springframework.stereotype.Component;

@Component
public class CruiseDto {

    public Cruise mapToCruise(CruiseRequest cruiseRequest) {
        Cruise cruise = new Cruise();
        if (cruiseRequest.getId() != null) {
            cruise.setId(cruiseRequest.getId());
        }
        cruise.setName(cruiseRequest.getName() );
        cruise.setDescription(cruiseRequest.getDescription());
        cruise.setPhoto(cruiseRequest.getPhoto());
        cruise.setCapacity(cruiseRequest.getCapacity());

        return cruise;
    }

}
