package com.example.springexploring.service;

import com.example.springexploring.controller.VoteCommand;
import org.springframework.transaction.annotation.Transactional;

public interface RatingService {
    @Transactional
    void vote(VoteCommand command);
}
