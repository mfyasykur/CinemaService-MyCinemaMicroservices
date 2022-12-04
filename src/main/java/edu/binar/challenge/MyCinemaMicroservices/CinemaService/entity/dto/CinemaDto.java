package edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.City;
import lombok.Data;

@JsonIgnoreProperties(
        value = {"cinemaId"},
        allowGetters = true
)
@Data
public class CinemaDto {

    @JsonProperty("cinemaId")
    @JsonIgnore
    private Long cinemaId;

    private String name;

    private int totalCinemaHalls;

    private City city;
}
