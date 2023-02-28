package com.example.springexploring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindTextReviewAndNameOfUserWhoReviewedDTO {
    private Long userId;

    private String userFullName;

    private String reviewText;
}
