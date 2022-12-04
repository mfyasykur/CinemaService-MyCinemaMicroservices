package edu.binar.challenge.MyCinemaMicroservices.CinemaService.service.impl;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.CinemaSeat;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.repository.CinemaSeatRepository;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.service.CinemaSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaSeatServiceImpl implements CinemaSeatService {

    @Autowired
    private CinemaSeatRepository cinemaSeatRepository;

    @Override
    public List<CinemaSeat> getAllCinemaSeats(){
        return cinemaSeatRepository.findAll();
    }

    private static final String MESSAGE = "CinemaHall not found for this id :: ";

    @Override
    public CinemaSeat getCinemaSeatById(Long cinemaSeatId) throws ResourceNotFoundException {
        CinemaSeat cinemaSeat = cinemaSeatRepository.findById(cinemaSeatId)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE + cinemaSeatId));

        return cinemaSeatRepository.save(cinemaSeat);
    }

    @Override
    public CinemaSeat createCinemaSeat(CinemaSeat cinemaSeat){
        return cinemaSeatRepository.save(cinemaSeat);
    }

    @Override
    public CinemaSeat updateCinemaSeat(Long cinemaSeatId, CinemaSeat cinemaSeatDetails) throws ResourceNotFoundException {
        CinemaSeat cinemaSeat = cinemaSeatRepository.findById(cinemaSeatId)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE + cinemaSeatId));

        cinemaSeat.setSeatNumber(cinemaSeatDetails.getSeatNumber());
        cinemaSeat.setType(cinemaSeatDetails.getType());
        cinemaSeat.setCinemaHall(cinemaSeatDetails.getCinemaHall());

        return cinemaSeatRepository.save(cinemaSeat);
    }

    @Override
    public void deleteCinemaSeat(Long cinemaSeatId) throws ResourceNotFoundException {
        CinemaSeat cinemaSeat = cinemaSeatRepository.findById(cinemaSeatId)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE + cinemaSeatId));

        cinemaSeatRepository.delete(cinemaSeat);
    }

}
