package com.example.springexploring.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@Builder
public class ReviewDTO {

    private UserDTO userDTO;

    private String comment;

}
