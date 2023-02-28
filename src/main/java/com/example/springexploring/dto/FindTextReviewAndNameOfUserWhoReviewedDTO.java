package com.example.springexploring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindTextReviewAndNameOfUserWhoReviewedDTO {
    Long userId;

    String userFullName;

    String reviewText;
}
