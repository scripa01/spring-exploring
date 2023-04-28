package com.example.springexploring.service;

import com.example.springexploring.controller.AddCommand.AddReviewCommand;
import com.example.springexploring.controller.UpdateCommand.UpdateReviewCommand;
import com.example.springexploring.dto.FindTextReviewAndNameOfUserWhoReviewedDTO;
import com.example.springexploring.dto.Mapper.Mapper;
import com.example.springexploring.entity.Item;
import com.example.springexploring.entity.Order;
import com.example.springexploring.entity.Review;
import com.example.springexploring.entity.User;
import com.example.springexploring.exception.CustomRuntimeException;
import com.example.springexploring.projection.FindTextReviewAndNameOfUserWhoReviewedProjections;
import com.example.springexploring.repository.ItemRepository;
import com.example.springexploring.repository.ReviewRepository;
import com.example.springexploring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class ReviewServiceImpl implements ReviewService {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final ReviewRepository reviewRepository;

    private final Mapper<FindTextReviewAndNameOfUserWhoReviewedProjections, FindTextReviewAndNameOfUserWhoReviewedDTO> findTextReviewAndNameOfUserWhoReviewedDTOMapper;

    @Override
    @Transactional
    public void save(AddReviewCommand reviewCommand) {
        User user = userRepository.findById(reviewCommand.getUserId()).orElseThrow(() -> new CustomRuntimeException("user with id - " + reviewCommand.getUserId() + " not found"));
        Item item = itemRepository.findById(reviewCommand.getItemId()).orElseThrow(() -> new CustomRuntimeException("item with id - " + reviewCommand.getItemId() + " not found"));
        Review review = new Review(reviewCommand.getComment(), user, item);
        assertThatUserCanWriteReviewForItem(item, user);
        assertThatUserCanWriteReviewOnce(item, user);
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void update(UpdateReviewCommand updateReview) {
        Review review = reviewRepository.findById(updateReview.getReviewId()).orElseThrow(() -> new CustomRuntimeException("Review with id - " + updateReview.getReviewId() + " not found"));
        User user = userRepository.findById(updateReview.getUserId()).orElseThrow(() -> new CustomRuntimeException("User with id - " + review.getUser().getId() + " not found"));
        assertThatUserPutReview(review, user);
        review.setComment(updateReview.getComment());
        reviewRepository.save(review);
    }

    @Override
    public List<FindTextReviewAndNameOfUserWhoReviewedDTO> findTextReviewAndNameOfUser(Long itemId) {
        List<FindTextReviewAndNameOfUserWhoReviewedProjections> findTextReviewAndNameOfUserWhoReviewedProjections = reviewRepository.findReviewByIdAndFindUser(itemId);
        List<FindTextReviewAndNameOfUserWhoReviewedDTO> findTextReviewAndNameOfUserWhoReviewedDTO = new ArrayList<>();

        for (FindTextReviewAndNameOfUserWhoReviewedProjections e : findTextReviewAndNameOfUserWhoReviewedProjections) {
            findTextReviewAndNameOfUserWhoReviewedDTO.add(findTextReviewAndNameOfUserWhoReviewedDTOMapper.map(e));
        }

        return findTextReviewAndNameOfUserWhoReviewedDTO;
    }

    private void assertThatUserCanWriteReviewForItem(Item item, User user) {
        List<Order> orders = user.getOrders();
        for (Order order : orders) {
            if (order.getDeliveryDate() != null
                    && order.getItems().contains(item)) {
                return;
            }
        }
        throw new CustomRuntimeException("User cannot write review for this Item!");
    }
    public void assertThatUserCanWriteReviewOnce(Item item, User user){
        List<Review> reviews = item.getReviews();
        for (Review review : reviews){
            if(review.getUser().equals(user))
                throw new CustomRuntimeException("User is already put review for this Item !");
        }
    }
    private void assertThatUserPutReview(Review review, User user) {
        if (!user.equals(review.getUser())) {
            throw new CustomRuntimeException("This user can't put review!");
        }
    }


}
