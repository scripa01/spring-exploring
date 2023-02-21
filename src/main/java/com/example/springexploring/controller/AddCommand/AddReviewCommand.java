package com.example.springexploring.controller.AddCommand;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddReviewCommand {
    @NotNull
    private Long userId;
    @NotNull
    private Long itemId;
    @NotBlank(message = "comment should not be empty!")
    private String comment;
}
