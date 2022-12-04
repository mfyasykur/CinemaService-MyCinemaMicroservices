package edu.binar.challenge.MyCinemaMicroservices.CinemaService.converter;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.ShowSeat;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto.ShowSeatDto;
import org.modelmapper.ModelMapper;

public class ShowSeatConverter {

    private ShowSeatConverter() {
        throw new IllegalStateException();
    }

    private static final ModelMapper modelMapper = new ModelMapper();

    public static ShowSeat convertDtoToEntity(ShowSeatDto showSeatDto){
        return modelMapper.map(showSeatDto, ShowSeat.class);
    }

    public static ShowSeatDto convertEntityToDto(ShowSeat showSeat){
        return modelMapper.map(showSeat, ShowSeatDto.class);
    }
}
