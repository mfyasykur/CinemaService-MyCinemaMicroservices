package edu.binar.challenge.MyCinemaMicroservices.CinemaService.service;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.CinemaHall;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;

import java.util.List;

public interface CinemaHallService {

    List<CinemaHall> getAllCinemaHalls();
    CinemaHall getCinemaHallById(Long cinemaHallId) throws ResourceNotFoundException;
    CinemaHall createCinemaHall(CinemaHall cinemaHall);
    CinemaHall updateCinemaHall(Long cinemaHallId, CinemaHall cinemaHall) throws ResourceNotFoundException;
    void deleteCinemaHall(Long cinemaHallId) throws ResourceNotFoundException;
}
