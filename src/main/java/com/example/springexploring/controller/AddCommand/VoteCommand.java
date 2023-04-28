package com.example.springexploring.controller.AddCommand;

import lombok.Data;

@Data
public class VoteCommand {

    private Long votedByUserId;
    private Long votedForUserId;
    private int stars;
}
