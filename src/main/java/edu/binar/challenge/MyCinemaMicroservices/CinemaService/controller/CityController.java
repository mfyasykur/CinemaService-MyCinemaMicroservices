package edu.binar.challenge.MyCinemaMicroservices.CinemaService.controller;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.converter.CityConverter;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.City;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto.CityDto;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.service.CityService;
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
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities/")
    public List<CityDto> getAllCities() {
        return cityService.getAllCities().stream().map(city -> new ModelMapper().map(city, CityDto.class))
                .toList();
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<CityDto> getCityById(@PathVariable(value = "cityId") Long cityId)
            throws ResourceNotFoundException {

        City city = cityService.getCityById(cityId);
        CityDto cityResponse = CityConverter.convertEntityToDto(city);

        return ResponseEntity.ok().body(cityResponse);
    }

    @PostMapping("/city")
    public ResponseEntity<CityDto> createCity(@Valid @RequestBody CityDto cityDto){

        City cityRequest = CityConverter.convertDtoToEntity(cityDto);
        City city = cityService.createCity(cityRequest);
        CityDto cityResponse = CityConverter.convertEntityToDto(city);

        return new ResponseEntity<>(cityResponse, HttpStatus.CREATED);
    }

    @PutMapping("/city/{cityId}")
    public ResponseEntity<CityDto> updateCity(@PathVariable(value = "cityId") Long cityId, @Valid @RequestBody CityDto cityDto) throws ResourceNotFoundException {

        City cityRequest = CityConverter.convertDtoToEntity(cityDto);
        City city = cityService.updateCity(cityId, cityRequest);
        CityDto cityResponse = CityConverter.convertEntityToDto(city);

        return new ResponseEntity<>(cityResponse, HttpStatus.OK);
    }

    @DeleteMapping("/city/{cityId}")
    public ResponseEntity<String> deleteCity(@PathVariable(value = "cityId") Long cityId) throws ResourceNotFoundException {
        cityService.deleteCity(cityId);

        return ResponseEntity.ok().body("City with ID(" + cityId + ") deleted successfully");
    }
}
