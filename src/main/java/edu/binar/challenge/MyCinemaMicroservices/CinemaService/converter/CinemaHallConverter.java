package edu.binar.challenge.MyCinemaMicroservices.CinemaService.converter;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.CinemaHall;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto.CinemaHallDto;
import org.modelmapper.ModelMapper;

public class CinemaHallConverter {

    private CinemaHallConverter() {
        throw new IllegalStateException();
    }

    private static final ModelMapper modelMapper = new ModelMapper();

    public static CinemaHall convertDtoToEntity(CinemaHallDto cinemaHallDto){
        return modelMapper.map(cinemaHallDto, CinemaHall.class);
    }

    public static CinemaHallDto convertEntityToDto(CinemaHall cinemaHall){
        return modelMapper.map(cinemaHall, CinemaHallDto.class);
    }
}
