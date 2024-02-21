package org.example.pet.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.pet.dto.ReservationDto;
import org.example.pet.mapper.ReservationMapper;
import org.example.pet.model.AnimalModel;
import org.example.pet.model.ReservationModel;
import org.example.pet.model.User;
import org.example.pet.repository.AnimalRepository;
import org.example.pet.repository.ReservationRepository;
import org.example.pet.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final AnimalRepository animalRepository;
    public ReservationDto addReservation(ReservationDto reservationDto) {
            ReservationModel reservationModel = ReservationMapper.toReservationModel(reservationDto);
          /*  User userModel = userRepository.findUserByLogin(reservationDto.getUserName()).orElseThrow();
            reservationModel.setUser(userModel);
            AnimalModel animalModel = animalRepository.findById(reservationDto.getAnimalId()).orElseThrow();
            reservationModel.setAnimal(animalModel);*/
            ReservationModel addReservation = reservationRepository.save(reservationModel);
            return ReservationMapper.toReservationDto(addReservation);
        }
    public List<ReservationDto> getReservationList() {
    return reservationRepository.findAll().stream().map(reservationModel -> ReservationMapper.toReservationDto(reservationModel)).toList();}

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public ReservationDto editReservation(Long id, ReservationDto updatedReservationDto) {
        Optional<ReservationModel> reservationOptional = reservationRepository.findById(id);

        if (reservationOptional.isPresent()) {
            ReservationModel existingReservation = reservationOptional.get();
            existingReservation.setStartDate(updatedReservationDto.getStartDate());
            existingReservation.setEndDate(updatedReservationDto.getEndDate());
            existingReservation.setReservationStatus(updatedReservationDto.getReservationStatus());
            existingReservation.setPrice(updatedReservationDto.getPrice());
            existingReservation.setRoomStandard(updatedReservationDto.getRoomStandard());
            existingReservation.setAnimalSize(updatedReservationDto.getAnimalSize());
            existingReservation.setAdditionalTreatment(updatedReservationDto.getAdditionalTreatment());
            ReservationModel updatedReservation = reservationRepository.save(existingReservation);
            return ReservationMapper.toReservationDto(updatedReservation);
        } else {
            throw new NoSuchElementException("Reservation with id " + id + " not found");
        }
    }
}
