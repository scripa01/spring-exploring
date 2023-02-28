package com.example.springexploring.service;


import com.example.springexploring.controller.AddCommand.AddReviewCommand;
import com.example.springexploring.controller.UpdateCommand.UpdateReviewCommand;
import com.example.springexploring.dto.FindTextReviewAndNameOfUserWhoReviewedDTO;

import java.util.List;

public interface ReviewService {
    void save(AddReviewCommand reviewCommand);

    void update(UpdateReviewCommand updateReview);

    List<FindTextReviewAndNameOfUserWhoReviewedDTO> findTextReviewAndNameOfUser(Long itemId);
}
