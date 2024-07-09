package org.example.uberprojectentityservice.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" , "bookings"})
public class Driver extends BaseModel{
    private String name;

    private String licenseNumber;

    private String phoneNumber;

    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
    private Car car;

    @Enumerated(value = EnumType.STRING)
    private DriverApprovalStatus driverApprovalStatus;

    @OneToOne
    private ExactLocation exactLocation;

    @OneToOne
    private ExactLocation home;

    private Boolean isActive;

    private String activeCity;

    @DecimalMin(value = "0.00", message = "Rating must >= 0.00")
    @DecimalMax(value = "5.00", message = "Rating must be <= 5.00")
    private Double rating;

    @OneToMany(mappedBy = "driver")
    @Fetch(FetchMode.SUBSELECT) // To resolved (n+1) problem.
    private List<Booking> bookings = new ArrayList<>();
}
