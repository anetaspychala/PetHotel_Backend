package org.example.pet.dto;

import lombok.Data;

import java.util.Set;

@Data
public class AnimalDto {
    private Long id;
    private String type;
    private Integer weight;
    private String name;
    private String sex;
    private Long ownerId;

}
