package org.example.pet.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pet.dto.AnimalDto;
import org.example.pet.service.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/auth/admin")
public class AnimalController {
    private final AnimalService animalService;


    @GetMapping("/animals")
    public List<AnimalDto> getAnimalList() {
        List<AnimalDto> animalList = animalService.getAnimalList();
        return animalList;
    }

    @DeleteMapping("/deleteAnimal/{id}")
    public ResponseEntity<String> deleteAnimal(@PathVariable Long id) {
        try {
            animalService.deleteAnimal(id);
            return ResponseEntity.ok("Animal deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting animal");
        }
    }


    @PutMapping("/editAnimal/{id}")
    public ResponseEntity<?> editAnimal(@PathVariable Long id, @RequestBody AnimalDto updatedAnimalDto) {
        try {
            AnimalDto editedAnimal = animalService.editAnimal(id, updatedAnimalDto);
            return ResponseEntity.ok(editedAnimal);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error editing animal");
        }
    }
}
