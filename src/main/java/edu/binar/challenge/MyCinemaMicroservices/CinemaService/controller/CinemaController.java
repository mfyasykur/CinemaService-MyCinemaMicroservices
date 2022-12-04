package edu.binar.challenge.MyCinemaMicroservices.CinemaService.controller;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.converter.CinemaConverter;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Cinema;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto.CinemaDto;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.service.CinemaService;
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
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/cinemas/")
    public List<CinemaDto> getAllCinemas() {
        return cinemaService.getAllCinemas().stream().map(cinema -> new ModelMapper().map(cinema, CinemaDto.class))
                .toList();
    }

    @GetMapping("/cinema/{cinemaId}")
    public ResponseEntity<CinemaDto> getCinemaById(@PathVariable(value = "cinemaId") Long cinemaId)
            throws ResourceNotFoundException {

        Cinema cinema = cinemaService.getCinemaById(cinemaId);
        CinemaDto cinemaResponse = CinemaConverter.convertEntityToDto(cinema);

        return ResponseEntity.ok().body(cinemaResponse);
    }

    @PostMapping("/cinema")
    public ResponseEntity<CinemaDto> createCinema(@Valid @RequestBody CinemaDto cinemaDto){

        Cinema cinemaRequest = CinemaConverter.convertDtoToEntity(cinemaDto);
        Cinema cinema = cinemaService.createCinema(cinemaRequest);
        CinemaDto cinemaResponse = CinemaConverter.convertEntityToDto(cinema);

        return new ResponseEntity<>(cinemaResponse, HttpStatus.CREATED);
    }

    @PutMapping("/cinema/{cinemaId}")
    public ResponseEntity<CinemaDto> updateCinema(@PathVariable(value = "cinemaId") Long cinemaId, @Valid @RequestBody CinemaDto cinemaDto) throws ResourceNotFoundException {

        Cinema cinemaRequest = CinemaConverter.convertDtoToEntity(cinemaDto);
        Cinema cinema = cinemaService.updateCinema(cinemaId, cinemaRequest);
        CinemaDto cinemaResponse = CinemaConverter.convertEntityToDto(cinema);

        return new ResponseEntity<>(cinemaResponse, HttpStatus.OK);
    }

    @DeleteMapping("/cinema/{cinemaId}")
    public ResponseEntity<String> deleteCinema(@PathVariable(value = "cinemaId") Long cinemaId) throws ResourceNotFoundException {
        cinemaService.deleteCinema(cinemaId);

        return ResponseEntity.ok().body("Cinema with ID(" + cinemaId + ") deleted successfully");
    }
}
