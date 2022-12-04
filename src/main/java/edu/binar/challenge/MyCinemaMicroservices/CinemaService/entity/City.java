package edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cityId;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "state", length = 64)
    private String state;

    @Column(name = "zipCode", length = 16)
    private String zipCode;
}
