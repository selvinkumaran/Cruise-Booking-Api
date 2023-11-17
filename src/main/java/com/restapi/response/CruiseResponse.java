package com.restapi.response;

import com.restapi.model.Cruise;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CruiseResponse {
    private List<Cruise> cruiseList;
}
