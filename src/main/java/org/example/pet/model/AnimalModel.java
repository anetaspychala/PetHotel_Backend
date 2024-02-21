package org.example.pet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity
@Data
@Table(name="animal_model")
public class AnimalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


   @OneToMany(mappedBy = "animal")
    private Set<ReservationModel> reservations;
}

