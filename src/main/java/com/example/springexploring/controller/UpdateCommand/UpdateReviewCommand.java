package com.example.springexploring.controller.UpdateCommand;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class UpdateReviewCommand {

    private Long id;
    private Long userId;
    @NotBlank(message = "comment should not be empty!")
    private String comment;
}
