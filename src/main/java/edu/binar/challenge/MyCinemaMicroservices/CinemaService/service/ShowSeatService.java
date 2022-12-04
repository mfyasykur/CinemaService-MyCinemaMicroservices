package edu.binar.challenge.MyCinemaMicroservices.CinemaService.service;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.ShowSeat;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto.ResponseTemplateDto;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;

import java.util.List;

public interface ShowSeatService {

    List<ShowSeat> getAllShowSeats();
    ShowSeat getShowSeatById(Long showSeatId) throws ResourceNotFoundException;
    ShowSeat createShowSeat(ShowSeat showSeat);
    ShowSeat updateShowSeat(Long showSeatId, ShowSeat showSeat) throws ResourceNotFoundException;
    void deleteShowSeat(Long showSeatId) throws ResourceNotFoundException;
    ResponseTemplateDto getShowSeatWithBooking(Long id) throws ResourceNotFoundException;
}
