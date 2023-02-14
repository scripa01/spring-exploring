package com.example.springexploring.controller.UpdateCommand;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ToString
public class UpdateOrderCommand {


    private Long id;

    @NotEmpty
    private List<Long> items;
    @NotNull
    private Long userId;

}
