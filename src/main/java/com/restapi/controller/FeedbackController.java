package com.restapi.controller;

import com.restapi.model.Feedback;
import com.restapi.model.Role;
import com.restapi.request.FeedbackRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@RolesAllowed(Role.USER)
public class FeedbackController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/{userId}")
    public ResponseEntity<APIResponse> getFeedbackDetails(@PathVariable Long userId) {
        List<Feedback> feedbackList = feedbackService.getFeedbackByUserId(userId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(feedbackList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse> createFeedback(@Valid @RequestBody
                                                      FeedbackRequest feedbackRequest) {
        List<Feedback> feedbackList = feedbackService.create(feedbackRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(feedbackList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateFeedback(@Valid @RequestBody
                                                    FeedbackRequest feedbackRequest) {
        List<Feedback> feedbackList  = feedbackService.update(feedbackRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(feedbackList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteFeedback(@PathVariable Long id) {
        List<Feedback> feedbackList  = feedbackService
                .deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(feedbackList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/{id}")
    public ResponseEntity<APIResponse> deleteFeedback(@PathVariable Long userId, @PathVariable Long id) {
        List<Feedback> feedbackList = feedbackService.deleteById(id, userId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(feedbackList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
