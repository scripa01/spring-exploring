package com.example.springexploring.dto.Mapper;

import com.example.springexploring.dto.CountOrdersByUserDTO;
import com.example.springexploring.projection.CountOrdersByUserProjections;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountOrdersByUserMapper implements Mapper<CountOrdersByUserProjections, CountOrdersByUserDTO> {

    @Override
    public CountOrdersByUserDTO map(CountOrdersByUserProjections entity) {
        return new CountOrdersByUserDTO(entity.getUserID(), entity.getFullName(), entity.getCount(), entity.getOrderId());
    }
}
