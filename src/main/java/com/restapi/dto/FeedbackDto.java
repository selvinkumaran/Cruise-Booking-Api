package com.restapi.dto;

import com.restapi.model.Cruise;
import com.restapi.model.Feedback;
import com.restapi.request.CruiseRequest;
import com.restapi.request.FeedbackRequest;
import org.springframework.stereotype.Component;

@Component
public class FeedbackDto {
    public Feedback  mapToFeedback(FeedbackRequest feedbackRequest) {
        Feedback feedback = new Feedback();
        if (feedbackRequest.getId() != null) {
            feedback.setId(feedbackRequest.getId());
        }
        feedback.setComments(feedbackRequest.getComments());
        feedback.setRating(feedbackRequest.getRating());

        return feedback;
    }
}
