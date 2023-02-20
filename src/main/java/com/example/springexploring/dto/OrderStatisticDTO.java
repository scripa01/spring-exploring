package com.example.springexploring.dto;


import com.example.springexploring.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class OrderStatisticDTO {
    private Long orderId;
    private Long userId;
    private String userName;
    private LocalDateTime orderedDate;
    private LocalDateTime receivedDate;
    private Long daysDifference;
    private Status status;
    private List<Long> itemsId = new ArrayList<>();
}
