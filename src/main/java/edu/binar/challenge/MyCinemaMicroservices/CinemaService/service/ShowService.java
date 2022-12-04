package edu.binar.challenge.MyCinemaMicroservices.CinemaService.service;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Show;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;

import java.util.List;

public interface ShowService {

    List<Show> getAllShows();
    Show getShowById(Long showId) throws ResourceNotFoundException;
    Show createShow(Show show);
    Show updateShow(Long showId, Show show) throws ResourceNotFoundException;
    void deleteShow(Long showId) throws ResourceNotFoundException;
}
