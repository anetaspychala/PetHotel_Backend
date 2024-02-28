package org.example.pet.mapper;


import org.example.pet.dto.AnimalDto;
import org.example.pet.model.AnimalModel;

public class AnimalMapper {
    public static AnimalDto toAnimalDto(AnimalModel animalModel) {
        AnimalDto animalDto = new AnimalDto();
        animalDto.setId(animalModel.getId());
        animalDto.setType(animalModel.getType());
        animalDto.setName(animalModel.getName());
        animalDto.setWeight(animalModel.getWeight());
        animalDto.setSex(animalModel.getSex());
        if(animalModel.getUser()!=null){
            animalDto.setOwnerId(animalModel.getUser().getId());}
        return animalDto;
    }

    public static AnimalModel toAnimalModel(AnimalDto animalDto) {
        AnimalModel animalModel = new AnimalModel();
        animalModel.setId(animalDto.getId());
        animalModel.setType(animalDto.getType());
        animalModel.setName(animalDto.getName());
        animalModel.setWeight(animalDto.getWeight());
        animalModel.setSex(animalDto.getSex());
        return animalModel;
    }
}
