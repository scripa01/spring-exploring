package com.example.springexploring.service;


import com.example.springexploring.controller.AddCommand.AddReviewCommand;
import com.example.springexploring.controller.UpdateCommand.UpdateReviewCommand;
import org.springframework.transaction.annotation.Transactional;

public interface ReviewService {
    void save(AddReviewCommand reviewCommand);

    void update(UpdateReviewCommand updateReview);
}
