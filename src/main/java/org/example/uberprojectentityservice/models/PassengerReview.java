package org.example.uberprojectentityservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
public class PassengerReview extends Review {

    @Column(nullable = false)
    private String PassengerReviewContent;

    @Column(nullable = false)
    private String PassengerRating;
}
