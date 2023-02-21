package com.example.springexploring.service;

import com.example.springexploring.controller.AddCommand.AddReviewCommand;
import com.example.springexploring.controller.UpdateCommand.UpdateReviewCommand;
import com.example.springexploring.entity.Item;
import com.example.springexploring.entity.Order;
import com.example.springexploring.entity.Review;
import com.example.springexploring.entity.User;
import com.example.springexploring.exception.CustomRuntimeException;
import com.example.springexploring.repository.ItemRepository;
import com.example.springexploring.repository.ReviewRepository;
import com.example.springexploring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class ReviewServiceImpl implements ReviewService {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public void save(AddReviewCommand reviewCommand) {
        User user = userRepository.findById(reviewCommand.getUserId()).orElseThrow(() -> new CustomRuntimeException("user with id - " + reviewCommand.getUserId() + " not found"));
        Item item = itemRepository.findById(reviewCommand.getItemId()).orElseThrow(() -> new CustomRuntimeException("item with id - " + reviewCommand.getItemId() + " not found"));
        Review review = new Review(reviewCommand.getComment(), user, item);
        assertThatUserCanWriteReviewForItem(item, user);
        reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void update(UpdateReviewCommand updateReview) {
        Review review = reviewRepository.findById(updateReview.getId()).orElseThrow(() -> new CustomRuntimeException("Review with id - " + updateReview.getId() + " not found"));
        User user = userRepository.findById(updateReview.getUserId()).orElseThrow(() -> new CustomRuntimeException("User with id - " + review.getUser().getId() + " not found"));
        assertThatUserPutReview(review, user);
        review.setComment(updateReview.getComment());
        reviewRepository.save(review);
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

    private void assertThatUserPutReview(Review review, User user) {
        if (!review.getUser().getId().equals(user.getId())) {
            throw new CustomRuntimeException("This user can't put review!");
        }
    }


}
