package com.restapi.response;

import com.restapi.model.Feedback;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FeedbackResponse {
    private List<Feedback> feedbackList;
}
