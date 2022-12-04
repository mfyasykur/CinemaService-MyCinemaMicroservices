package edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.CinemaSeat;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Show;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.ShowSeat;
import lombok.Data;

@JsonIgnoreProperties(
        value = {"showSeatId"},
        allowGetters = true
)
@Data
public class ShowSeatDto {

    @JsonProperty("showSeatId")
    @JsonIgnore
    private Long showSeatId;

    private ShowSeat.showSeatStatus status;

    private CinemaSeat cinemaSeat;

    private Show show;

    private BookingDto booking;

}
