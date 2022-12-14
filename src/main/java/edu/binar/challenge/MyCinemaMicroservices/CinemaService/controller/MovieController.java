package edu.binar.challenge.MyCinemaMicroservices.CinemaService.controller;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.converter.MovieConverter;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Movie;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto.MovieDto;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.service.MovieService;
import jakarta.validation.Valid;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Setter
@RestController
@RequestMapping("/api/mycinema-v1")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies/")
    public List<MovieDto> getAllMovies() {
        return movieService.getAllMovies().stream().map(movie -> new ModelMapper().map(movie, MovieDto.class))
                .toList();
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable(value = "movieId") Long movieId)
            throws ResourceNotFoundException {

        Movie movie = movieService.getMovieById(movieId);
        MovieDto movieResponse = MovieConverter.convertEntityToDto(movie);

        return ResponseEntity.ok().body(movieResponse);
    }

    @PostMapping("/movie")
    public ResponseEntity<MovieDto> createMovie(@Valid @RequestBody MovieDto movieDto){

        Movie movieRequest = MovieConverter.convertDtoToEntity(movieDto);
        Movie movie = movieService.createMovie(movieRequest);
        MovieDto movieResponse = MovieConverter.convertEntityToDto(movie);

        return new ResponseEntity<>(movieResponse, HttpStatus.CREATED);
    }

    @PutMapping("/movie/{movieId}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable(value = "movieId") Long movieId, @Valid @RequestBody MovieDto movieDto) throws ResourceNotFoundException {

        Movie movieRequest = MovieConverter.convertDtoToEntity(movieDto);
        Movie movie = movieService.updateMovie(movieId, movieRequest);
        MovieDto movieResponse = MovieConverter.convertEntityToDto(movie);

        return new ResponseEntity<>(movieResponse, HttpStatus.OK);
    }

    @DeleteMapping("/movie/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable(value = "movieId") Long movieId) throws ResourceNotFoundException {
        movieService.deleteMovie(movieId);

        return ResponseEntity.ok().body("Movie with ID(" + movieId + ") deleted successfully");
    }
}
