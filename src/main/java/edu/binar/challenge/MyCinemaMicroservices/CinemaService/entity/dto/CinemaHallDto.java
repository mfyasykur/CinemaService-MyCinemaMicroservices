package edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Cinema;
import lombok.Data;

@JsonIgnoreProperties(
        value = {"cinemaHallId"},
        allowGetters = true
)
@Data
public class CinemaHallDto {

    @JsonProperty("cinemaHallId")
    @JsonIgnore
    private long cinemaHallId;

    private String name;

    private int totalSeats;

    private Cinema cinema;
}
