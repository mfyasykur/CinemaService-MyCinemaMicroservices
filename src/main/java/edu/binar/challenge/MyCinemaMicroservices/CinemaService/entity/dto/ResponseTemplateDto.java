package edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.ShowSeat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseTemplateDto {

    private ShowSeat showSeat;
    private BookingDto booking;
}
