package com.restapi.service;

import com.restapi.dto.FeedbackDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.AppUser;
import com.restapi.model.Feedback;
import com.restapi.repository.FeedbackRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.FeedbackRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackDto feedbackDto;

    @Autowired
    private UserRepository userRepository;

    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    private void setAppUser(Feedback feedback, Long userId) {
        AppUser appUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId", userId));

        feedback.setAppUser(appUser);
    }

    public List<Feedback> create(FeedbackRequest feedbackRequest) {
        Feedback feedback = feedbackDto.mapToFeedback(feedbackRequest);
        setAppUser(feedback, feedbackRequest.getUserId());
        feedbackRepository.save(feedback);
        return findAll();
    }

    public List<Feedback> update(FeedbackRequest feedbackRequest) {
        Feedback feedback = feedbackDto.mapToFeedback(feedbackRequest);
        setAppUser(feedback, feedbackRequest.getUserId());
        feedbackRepository.save(feedback);
        return findAll();
    }

    public List<Feedback> deleteById(Long id) {
        feedbackRepository.deleteById(id);
        return findAll();
    }

    public List<Feedback> deleteById(Long id, Long userId) {
        feedbackRepository.deleteById(id);
        return getFeedbackByUserId(userId); // Fetch feedbacks for the specific userId
    }


    public List<Feedback> getFeedbackByUserId(Long userId) {
        return feedbackRepository.findByAppUser_Id(userId);
    }

}
