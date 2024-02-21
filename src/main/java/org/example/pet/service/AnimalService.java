package org.example.pet.service;
import lombok.RequiredArgsConstructor;
import org.example.pet.dto.AnimalDto;
import org.example.pet.mapper.AnimalMapper;
import org.example.pet.model.AnimalModel;
import org.example.pet.model.User;
import org.example.pet.repository.AnimalRepository;
import org.example.pet.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final UserRepository userRepository;

    public AnimalDto addAnimal(AnimalDto animalDto) {
        AnimalModel animalModel = AnimalMapper.toAnimalModel(animalDto);
       /* User userModel = userRepository.findUserByLogin(animalDto.getUserName()).orElseThrow();
        animalModel.setUser(userModel);*/
        AnimalModel addAnimal = animalRepository.save(animalModel);
        return AnimalMapper.toAnimalDto(addAnimal);
    }

    public List<AnimalDto> getAnimalList() {
        return animalRepository.findAll().stream().map(animalModel -> AnimalMapper.toAnimalDto(animalModel)).toList();
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }


    public AnimalDto editAnimal(Long id, AnimalDto updatedAnimalDto) {
        Optional<AnimalModel> animalOptional = animalRepository.findById(id);

        if (animalOptional.isPresent()) {
            AnimalModel existingAnimal = animalOptional.get();
            existingAnimal.setName(updatedAnimalDto.getName());
            existingAnimal.setType(updatedAnimalDto.getType());
            existingAnimal.setSex(updatedAnimalDto.getSex());
            existingAnimal.setWeight(updatedAnimalDto.getWeight());
            AnimalModel updatedAnimal = animalRepository.save(existingAnimal);
            return AnimalMapper.toAnimalDto(updatedAnimal);
        } else {
            throw new NoSuchElementException("Animal with id " + id + " not found");
        }
    }
}