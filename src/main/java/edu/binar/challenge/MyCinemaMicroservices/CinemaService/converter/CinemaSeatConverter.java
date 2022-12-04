package edu.binar.challenge.MyCinemaMicroservices.CinemaService.converter;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.CinemaSeat;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto.CinemaSeatDto;
import org.modelmapper.ModelMapper;

public class CinemaSeatConverter {

    private CinemaSeatConverter() {
        throw new IllegalStateException();
    }

    private static final ModelMapper modelMapper = new ModelMapper();

    public static CinemaSeat convertDtoToEntity(CinemaSeatDto cinemaSeatDto){
        return modelMapper.map(cinemaSeatDto, CinemaSeat.class);
    }

    public static CinemaSeatDto convertEntityToDto(CinemaSeat cinemaSeat){
        return modelMapper.map(cinemaSeat, CinemaSeatDto.class);
    }
}
