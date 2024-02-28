package org.example.pet.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
public class ReservationDto {

    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal price;

    private String reservationStatus;

    private String roomStandard;

    private Integer animalSize;

    private String additionalTreatment;

    private Long animalId;

}
