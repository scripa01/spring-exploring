package com.example.springexploring.dto.Mapper;

import com.example.springexploring.dto.FindTextReviewAndNameOfUserWhoReviewedDTO;
import com.example.springexploring.projection.FindTextReviewAndNameOfUserWhoReviewedProjections;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindTextReviewAndNameOfUserWhoReviewedMapper implements Mapper<FindTextReviewAndNameOfUserWhoReviewedProjections, FindTextReviewAndNameOfUserWhoReviewedDTO> {

    @Override
    public FindTextReviewAndNameOfUserWhoReviewedDTO map(FindTextReviewAndNameOfUserWhoReviewedProjections entity) {
        return new FindTextReviewAndNameOfUserWhoReviewedDTO(entity.getUserId(),entity.getUserFullName(), entity.getReviewText());
    }
}
