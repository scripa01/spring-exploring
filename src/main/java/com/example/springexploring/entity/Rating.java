package com.example.springexploring.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "RATING")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Rating {

    @Id
    @SequenceGenerator(name = "vote_sequence", sequenceName = "vote_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vote_sequence")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voted_by", nullable = false)
    private User votedBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voted_for", nullable = false)
    private User votedFor;

    private Integer stars;

    public Rating(User votedBy, User votedFor, Integer stars) {
        this.votedBy = votedBy;
        this.votedFor = votedFor;
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return Objects.equals(id, rating.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
