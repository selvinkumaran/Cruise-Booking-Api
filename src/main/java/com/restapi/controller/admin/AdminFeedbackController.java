package com.restapi.controller.admin;


import com.restapi.model.Feedback;
import com.restapi.model.Role;
import com.restapi.response.common.APIResponse;
import com.restapi.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/admin/feedback")
@RolesAllowed(Role.ADMIN)
public class AdminFeedbackController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private FeedbackService feedbackService;
    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllFeedback() {
        List<Feedback> feedbackList = feedbackService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(feedbackList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
