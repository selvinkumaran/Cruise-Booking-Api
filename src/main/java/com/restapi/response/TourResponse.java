package com.restapi.response;

import com.restapi.model.Tour;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TourResponse {
    private List<Tour> tourList;
}
