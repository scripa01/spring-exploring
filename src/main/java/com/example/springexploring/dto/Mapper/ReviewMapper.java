package com.example.springexploring.dto.Mapper;


import com.example.springexploring.dto.ReviewDTO;
import com.example.springexploring.dto.UserDTO;
import com.example.springexploring.entity.Review;
import com.example.springexploring.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewMapper implements Mapper<Review, ReviewDTO> {

    private final Mapper<User, UserDTO> userDTOMapper;

    @Override
    public ReviewDTO map(Review entity) {
        return new ReviewDTO(entity.getUser().getId(), entity.getComment());
    }
}
