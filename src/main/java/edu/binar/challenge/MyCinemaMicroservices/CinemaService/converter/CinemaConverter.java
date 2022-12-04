package edu.binar.challenge.MyCinemaMicroservices.CinemaService.converter;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Cinema;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto.CinemaDto;
import org.modelmapper.ModelMapper;

public class CinemaConverter {

    private CinemaConverter() {
        throw new IllegalStateException();
    }

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Cinema convertDtoToEntity(CinemaDto dto){
        return modelMapper.map(dto, Cinema.class);
    }

    public static CinemaDto convertEntityToDto(Cinema entity){
        return modelMapper.map(entity, CinemaDto.class);
    }
}
