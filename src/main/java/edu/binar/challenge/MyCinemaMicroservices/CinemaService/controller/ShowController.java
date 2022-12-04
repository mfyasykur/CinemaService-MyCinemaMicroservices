package edu.binar.challenge.MyCinemaMicroservices.CinemaService.controller;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.converter.ShowConverter;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Show;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto.ShowDto;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.service.ShowService;
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
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/shows/")
    public List<ShowDto> getAllShows() {
        return showService.getAllShows().stream().map(show -> new ModelMapper().map(show, ShowDto.class))
                .toList();
    }

    @GetMapping("/show/{showId}")
    public ResponseEntity<ShowDto> getShowById(@PathVariable(value = "showId") Long showId)
            throws ResourceNotFoundException {

        Show show = showService.getShowById(showId);
        ShowDto showResponse = ShowConverter.convertEntityToDto(show);

        return ResponseEntity.ok().body(showResponse);
    }

    @PostMapping("/show")
    public ResponseEntity<ShowDto> createShow(@Valid @RequestBody ShowDto showDto){

        Show showRequest = ShowConverter.convertDtoToEntity(showDto);
        Show show = showService.createShow(showRequest);
        ShowDto showResponse = ShowConverter.convertEntityToDto(show);

        return new ResponseEntity<>(showResponse, HttpStatus.CREATED);
    }

    @PutMapping("/show/{showId}")
    public ResponseEntity<ShowDto> updateShow(@PathVariable(value = "showId") Long showId, @Valid @RequestBody ShowDto showDto) throws ResourceNotFoundException {

        Show showRequest = ShowConverter.convertDtoToEntity(showDto);
        Show show = showService.updateShow(showId, showRequest);
        ShowDto showResponse = ShowConverter.convertEntityToDto(show);

        return new ResponseEntity<>(showResponse, HttpStatus.OK);
    }

    @DeleteMapping("/show/{showId}")
    public ResponseEntity<String> deleteShow(@PathVariable(value = "showId") Long showId) throws ResourceNotFoundException {
        showService.deleteShow(showId);

        return ResponseEntity.ok().body("Show with ID(" + showId + ") deleted successfully");
    }
}
