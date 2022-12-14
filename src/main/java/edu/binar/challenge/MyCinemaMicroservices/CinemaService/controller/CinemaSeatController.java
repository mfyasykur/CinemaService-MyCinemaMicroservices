package edu.binar.challenge.MyCinemaMicroservices.CinemaService.controller;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.converter.CinemaSeatConverter;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.CinemaSeat;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto.CinemaSeatDto;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.service.CinemaSeatService;
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
public class CinemaSeatController {

    @Autowired
    private CinemaSeatService cinemaSeatService;

    @GetMapping("/cinemaSeats/")
    public List<CinemaSeatDto> getAllCinemaSeats() {
        return cinemaSeatService.getAllCinemaSeats().stream().map(cinemaSeat -> new ModelMapper().map(cinemaSeat, CinemaSeatDto.class))
                .toList();
    }

    @GetMapping("/cinemaSeat/{cinemaSeatId}")
    public ResponseEntity<CinemaSeatDto> getCinemaSeatById(@PathVariable(value = "cinemaSeatId") Long cinemaSeatId)
            throws ResourceNotFoundException {

        CinemaSeat cinemaSeat = cinemaSeatService.getCinemaSeatById(cinemaSeatId);
        CinemaSeatDto cinemaSeatResponse = CinemaSeatConverter.convertEntityToDto(cinemaSeat);

        return ResponseEntity.ok().body(cinemaSeatResponse);
    }

    @PostMapping("/cinemaSeat")
    public ResponseEntity<CinemaSeatDto> createCinemaSeat(@Valid @RequestBody CinemaSeatDto cinemaSeatDto){

        CinemaSeat cinemaSeatRequest = CinemaSeatConverter.convertDtoToEntity(cinemaSeatDto);
        CinemaSeat cinemaSeat = cinemaSeatService.createCinemaSeat(cinemaSeatRequest);
        CinemaSeatDto cinemaSeatResponse = CinemaSeatConverter.convertEntityToDto(cinemaSeat);

        return new ResponseEntity<>(cinemaSeatResponse, HttpStatus.CREATED);
    }

    @PutMapping("/cinemaSeat/{cinemaSeatId}")
    public ResponseEntity<CinemaSeatDto> updateCinemaSeat(@PathVariable(value = "cinemaSeatId") Long cinemaSeatId, @Valid @RequestBody CinemaSeatDto cinemaSeatDto) throws ResourceNotFoundException {

        CinemaSeat cinemaSeatRequest = CinemaSeatConverter.convertDtoToEntity(cinemaSeatDto);
        CinemaSeat cinemaSeat = cinemaSeatService.updateCinemaSeat(cinemaSeatId, cinemaSeatRequest);
        CinemaSeatDto cinemaSeatResponse = CinemaSeatConverter.convertEntityToDto(cinemaSeat);

        return new ResponseEntity<>(cinemaSeatResponse, HttpStatus.OK);
    }

    @DeleteMapping("/cinemaSeat/{cinemaSeatId}")
    public ResponseEntity<String> deleteCinemaSeat(@PathVariable(value = "cinemaSeatId") Long cinemaSeatId) throws ResourceNotFoundException {
        cinemaSeatService.deleteCinemaSeat(cinemaSeatId);

        return ResponseEntity.ok().body("CinemaSeat with ID(" + cinemaSeatId + ") deleted successfully");
    }
}
