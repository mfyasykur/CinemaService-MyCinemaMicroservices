package edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Show;
import lombok.Data;

import java.time.LocalDateTime;

@JsonIgnoreProperties(
        value = {"bookingId"},
        allowGetters = true
)
@Data
public class BookingDto {

    @JsonProperty("bookingId")
    @JsonIgnore
    private Long bookingId;

    private int numberOfSeats;

    private LocalDateTime timeStamp;

    public enum BookingStatus {
        SUCCESS,
        CANCELED
    }

    private BookingStatus status;

    private UserDto user;

    private Show show;
}
