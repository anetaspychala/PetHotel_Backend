package org.example.pet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_Date")
    private LocalDate startDate;

    @Column(name = "end_Date")
    private LocalDate endDate;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "reservation_status")
    private String reservationStatus;

    @Column(name = "room_standard")
    private String roomStandard;

    @Column(name = "animal_size")
    private Integer animalSize;

    @Column(name = "additional_treatment")
    private String additionalTreatment;

    @ManyToOne
    @JoinColumn(name = "user_id") // wiele leczen do jednego zwierzecia, JoinColumn, klucz obcy id zwierzecia
    private User user;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private AnimalModel animal;
}
