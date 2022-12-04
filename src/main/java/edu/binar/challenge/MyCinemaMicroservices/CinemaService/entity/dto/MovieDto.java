package edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Movie;
import lombok.Data;

import java.util.Date;

@JsonIgnoreProperties(
        value = {"movieId"},
        allowGetters = true
)
@Data
public class MovieDto {

    @JsonProperty("movieId")
    @JsonIgnore
    private long movieId;

    private String title;

    private String description;

    private int duration;

    private String language;

    private Date releaseDate;

    private String country;

    private String genre;

    private Movie.showingStatus status;
}
