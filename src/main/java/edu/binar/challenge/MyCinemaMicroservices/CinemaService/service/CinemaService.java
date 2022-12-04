package edu.binar.challenge.MyCinemaMicroservices.CinemaService.service;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Cinema;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;

import java.util.List;

public interface CinemaService {

    List<Cinema> getAllCinemas();
    Cinema getCinemaById(Long cinemaId) throws ResourceNotFoundException;
    Cinema createCinema(Cinema cinema);
    Cinema updateCinema(Long cinemaId, Cinema cinema) throws ResourceNotFoundException;
    void deleteCinema(Long cinemaId) throws ResourceNotFoundException;
}
