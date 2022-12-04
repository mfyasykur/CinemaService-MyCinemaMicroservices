package edu.binar.challenge.MyCinemaMicroservices.CinemaService.converter;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Movie;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto.MovieDto;
import org.modelmapper.ModelMapper;

public class MovieConverter {

    private MovieConverter() {
        throw new IllegalStateException();
    }

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Movie convertDtoToEntity(MovieDto movieDto){
        return modelMapper.map(movieDto, Movie.class);
    }

    public static MovieDto convertEntityToDto(Movie movie){
        return modelMapper.map(movie, MovieDto.class);
    }
}
