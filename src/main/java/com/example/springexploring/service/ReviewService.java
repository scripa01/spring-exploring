package com.example.springexploring.service;


import com.example.springexploring.controller.AddCommand.AddReviewCommand;
import com.example.springexploring.controller.UpdateCommand.UpdateReviewCommand;
import org.springframework.transaction.annotation.Transactional;

public interface ReviewService {
    public void save(AddReviewCommand reviewCommand);

    @Transactional
    void update(UpdateReviewCommand updateReview);
}
