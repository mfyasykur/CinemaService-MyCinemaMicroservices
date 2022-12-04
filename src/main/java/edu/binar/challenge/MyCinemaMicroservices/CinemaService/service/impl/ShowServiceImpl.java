package edu.binar.challenge.MyCinemaMicroservices.CinemaService.service.impl;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Show;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.repository.ShowRepository;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Override
    public List<Show> getAllShows(){
        return showRepository.findAll();
    }

    private static final String MESSAGE = "Show not found for this id :: ";

    @Override
    public Show getShowById(Long showId) throws ResourceNotFoundException {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE + showId));

        return showRepository.save(show);
    }

    @Override
    public Show createShow(Show show){
        return showRepository.save(show);
    }

    @Override
    public Show updateShow(Long showId, Show showDetails) throws ResourceNotFoundException {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE + showId));

        show.setDate(showDetails.getDate());
        show.setStartTime(showDetails.getStartTime());
        show.setEndTime(showDetails.getEndTime());
        show.setCinemaHall(showDetails.getCinemaHall());
        show.setMovie(showDetails.getMovie());

        return showRepository.save(show);
    }

    @Override
    public void deleteShow(Long showId) throws ResourceNotFoundException {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE + showId));

        showRepository.delete(show);
    }
}
