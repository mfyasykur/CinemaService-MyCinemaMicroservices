package edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.CinemaHall;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Movie;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonIgnoreProperties(
        value = {"showId"},
        allowGetters = true
)
@Data
public class ShowDto {

    @JsonProperty("showId")
    @JsonIgnore
    private long showId;

    private LocalDate date;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private CinemaHall cinemaHall;

    private Movie movie;
}
