package org.example.uberprojectentityservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookingreview")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel {

    @Column(nullable = false)
    private String content;

    private Double rating;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // It will create foreign key in review table.
    @JoinColumn(nullable = false)
    private Booking booking;

    @Override
    public String toString() {
        return "Review " + this.content + "Rating " + this.rating;
    }
}
