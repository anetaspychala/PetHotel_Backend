package org.example.pet.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pet.dto.AnimalDto;
import org.example.pet.dto.ReservationDto;
import org.example.pet.service.AnimalService;
import org.example.pet.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/auth/user")
public class UserPanel {

    private final AnimalService animalService;
    private final ReservationService reservationService;

    @PostMapping("/addAnimal")
    public ResponseEntity<AnimalDto> addAnimal(@RequestBody AnimalDto animalDto) {
        try {
            AnimalDto addAnimal = animalService.addAnimal(animalDto);
            return ResponseEntity.ok(addAnimal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @PostMapping("/addReservation")
    public ResponseEntity<ReservationDto> addReservation(@RequestBody ReservationDto reservationDto) {
        try {
            ReservationDto addReservation = reservationService.addReservation(reservationDto);
            return ResponseEntity.ok(addReservation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
