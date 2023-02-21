package com.example.springexploring.controller;

import com.example.springexploring.controller.AddCommand.AddReviewCommand;
import com.example.springexploring.controller.UpdateCommand.UpdateReviewCommand;
import com.example.springexploring.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public void save(@RequestBody @Valid AddReviewCommand reviewCommand) {
        reviewService.save(reviewCommand);
    }

    @PutMapping()
    public void update(@RequestBody @Valid UpdateReviewCommand updateReviewCommand) {
        reviewService.update(updateReviewCommand);
    }
}
