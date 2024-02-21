package org.example.pet.repository;



import org.example.pet.model.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalModel, Long> {
    List<AnimalModel> findByNameIgnoreCase(String name);
}
