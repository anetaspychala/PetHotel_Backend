package org.example.pet.repository;

import org.example.pet.model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel, Long> {
}
