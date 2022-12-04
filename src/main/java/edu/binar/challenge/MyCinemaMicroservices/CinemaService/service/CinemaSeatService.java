package edu.binar.challenge.MyCinemaMicroservices.CinemaService.service;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.CinemaSeat;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;

import java.util.List;

public interface CinemaSeatService {

    List<CinemaSeat> getAllCinemaSeats();
    CinemaSeat getCinemaSeatById(Long cinemaSeatId) throws ResourceNotFoundException;
    CinemaSeat createCinemaSeat(CinemaSeat cinemaSeat);
    CinemaSeat updateCinemaSeat(Long cinemaSeatId, CinemaSeat cinemaSeat) throws ResourceNotFoundException;
    void deleteCinemaSeat(Long cinemaSeatId) throws ResourceNotFoundException;

}
