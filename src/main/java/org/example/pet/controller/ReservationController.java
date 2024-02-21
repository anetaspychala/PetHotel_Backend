package org.example.pet.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pet.dto.ReservationDto;
import org.example.pet.service.ReservationService;
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
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/reservations")
    public List<ReservationDto> getReservationList(ReservationDto reservation){
        List<ReservationDto> reservationList = reservationService.getReservationList();
        return reservationList;
    }
    @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id) {
        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.ok("Reservation deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting reservation");
        }
    }
    @PutMapping("/editReservation/{id}")
    public ResponseEntity<?> editReservation(@PathVariable Long id, @RequestBody ReservationDto updatedReservationDto) {
        try {
            ReservationDto editedReservation = reservationService.editReservation(id, updatedReservationDto);
            return ResponseEntity.ok(editedReservation);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservation not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error editing reservation");
        }
    }
}
