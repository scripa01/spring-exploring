package com.example.springexploring.controller.AddCommand;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data   //В комманде только айди!!!
public class AddOrderCommand {

    @NotEmpty
    private List<Long> itemsId = new ArrayList<>();

    @NotNull
    private Long userId;
}
