package org.example.pet.mapper;

import org.example.pet.dto.ReservationDto;
import org.example.pet.model.ReservationModel;

public class ReservationMapper {

    public static ReservationDto toReservationDto(ReservationModel reservationModel) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservationModel.getId());
        reservationDto.setPrice(reservationModel.getPrice());
        reservationDto.setStartDate(reservationModel.getStartDate());
        reservationDto.setEndDate(reservationModel.getEndDate());
        reservationDto.setRoomStandard(reservationModel.getRoomStandard());
        reservationDto.setAnimalSize(reservationModel.getAnimalSize());
        reservationDto.setAdditionalTreatment(reservationModel.getAdditionalTreatment());
        reservationDto.setReservationStatus(reservationModel.getReservationStatus());
        if(reservationModel.getAnimal()!=null){
        reservationDto.setAnimalId(reservationModel.getAnimal().getId());}
        return reservationDto;
    }

    public static ReservationModel toReservationModel(ReservationDto reservationDto) {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setId(reservationDto.getId());
        reservationModel.setPrice(reservationDto.getPrice());
        reservationModel.setStartDate(reservationDto.getStartDate());
        reservationModel.setEndDate(reservationDto.getEndDate());
        reservationModel.setReservationStatus(reservationDto.getReservationStatus());
        reservationModel.setRoomStandard(reservationDto.getRoomStandard());
        reservationModel.setAnimalSize(reservationDto.getAnimalSize());
        reservationModel.setAdditionalTreatment(reservationDto.getAdditionalTreatment());
        return reservationModel;
    }
}
