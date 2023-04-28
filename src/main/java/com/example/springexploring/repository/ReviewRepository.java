package com.example.springexploring.repository;

import com.example.springexploring.dto.FindTextReviewAndNameOfUserWhoReviewedDTO;
import com.example.springexploring.entity.Review;
import com.example.springexploring.projection.FindTextReviewAndNameOfUserWhoReviewedProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(nativeQuery = true, value = "SELECT user_id                        AS userId, " +
            "       first_name || ' ' || last_name AS userFullName, " +
            "       comment                        as reviewText " +
            " FROM review r " +
            "         JOIN users u on u.id = r.user_id WHERE r.item_id= :itemId ")
    List<FindTextReviewAndNameOfUserWhoReviewedProjections> findReviewByIdAndFindUser(@Param("itemId") Long itemId);
}
