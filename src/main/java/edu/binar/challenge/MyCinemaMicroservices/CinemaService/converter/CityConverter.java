package edu.binar.challenge.MyCinemaMicroservices.CinemaService.converter;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.City;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto.CityDto;
import org.modelmapper.ModelMapper;

public class CityConverter {

    private CityConverter() {
        throw new IllegalStateException();
    }

    private static final ModelMapper modelMapper = new ModelMapper();

    public static City convertDtoToEntity(CityDto cityDto){
        return modelMapper.map(cityDto, City.class);
    }

    public static CityDto convertEntityToDto(City city){
        return modelMapper.map(city, CityDto.class);
    }
}
