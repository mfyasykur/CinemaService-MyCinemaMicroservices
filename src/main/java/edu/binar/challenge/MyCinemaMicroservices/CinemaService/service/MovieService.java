package edu.binar.challenge.MyCinemaMicroservices.CinemaService.service;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Movie;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();
    Movie getMovieById(Long movieId) throws ResourceNotFoundException;
    Movie createMovie(Movie movie);
    Movie updateMovie(Long movieId, Movie movie) throws ResourceNotFoundException;
    void deleteMovie(Long movieId) throws ResourceNotFoundException;
}
