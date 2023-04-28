package com.example.springexploring.controller;

import com.example.springexploring.controller.AddCommand.AddReviewCommand;
import com.example.springexploring.controller.UpdateCommand.UpdateReviewCommand;
import com.example.springexploring.dto.FindTextReviewAndNameOfUserWhoReviewedDTO;
import com.example.springexploring.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/{itemId}")
    public ResponseEntity<List<FindTextReviewAndNameOfUserWhoReviewedDTO>> findReviewAndUserById(@PathVariable Long itemId) {
        return ResponseEntity.ok(reviewService.findTextReviewAndNameOfUser(itemId));
    }
}
