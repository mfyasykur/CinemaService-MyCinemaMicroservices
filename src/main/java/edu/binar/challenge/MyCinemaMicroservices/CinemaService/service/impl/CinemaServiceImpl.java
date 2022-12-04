package edu.binar.challenge.MyCinemaMicroservices.CinemaService.service.impl;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Cinema;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.repository.CinemaRepository;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public List<Cinema> getAllCinemas(){
        return cinemaRepository.findAll();
    }

    private static final String MESSAGE = "CinemaHall not found for this id :: ";

    @Override
    public Cinema getCinemaById(Long cinemaId) throws ResourceNotFoundException {
        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE + cinemaId));

        return cinemaRepository.save(cinema);
    }

    @Override
    public Cinema createCinema(Cinema cinema){
        return cinemaRepository.save(cinema);
    }

    @Override
    public Cinema updateCinema(Long cinemaId, Cinema cinemaDetails) throws ResourceNotFoundException {
        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE + cinemaId));

        cinema.setName(cinemaDetails.getName());
        cinema.setTotalCinemaHalls(cinemaDetails.getTotalCinemaHalls());
        cinema.setCity(cinemaDetails.getCity());

        return cinemaRepository.save(cinema);
    }

    @Override
    public void deleteCinema(Long cinemaId) throws ResourceNotFoundException {
        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE + cinemaId));

        cinemaRepository.delete(cinema);
    }
}
