package edu.binar.challenge.MyCinemaMicroservices.CinemaService.converter;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Show;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto.ShowDto;
import org.modelmapper.ModelMapper;

public class ShowConverter {

    private ShowConverter() {
        throw new IllegalStateException();
    }

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Show convertDtoToEntity(ShowDto showDto){
        return modelMapper.map(showDto, Show.class);
    }

    public static ShowDto convertEntityToDto(Show show){
        return modelMapper.map(show, ShowDto.class);
    }
}
