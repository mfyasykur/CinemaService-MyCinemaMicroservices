package edu.binar.challenge.MyCinemaMicroservices.CinemaService.service.impl;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.ShowSeat;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto.BookingDto;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.dto.ResponseTemplateDto;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.repository.ShowSeatRepository;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.service.ShowSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ShowSeatServiceImpl implements ShowSeatService {

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<ShowSeat> getAllShowSeats(){
        return showSeatRepository.findAll();
    }

    private static final String MESSAGE = "CinemaHall not found for this id :: ";

    @Override
    public ShowSeat getShowSeatById(Long showSeatId) throws ResourceNotFoundException {
        ShowSeat showSeat = showSeatRepository.findById(showSeatId)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE + showSeatId));

        return showSeatRepository.save(showSeat);
    }

    @Override
    public ShowSeat createShowSeat(ShowSeat showSeat){
        return showSeatRepository.save(showSeat);
    }

    @Override
    public ShowSeat updateShowSeat(Long showSeatId, ShowSeat showSeatDetails) throws ResourceNotFoundException {
        ShowSeat showSeat = showSeatRepository.findById(showSeatId)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE + showSeatId));

        showSeat.setStatus(showSeatDetails.getStatus());
        showSeat.setPrice(showSeatDetails.getPrice());
        showSeat.setCinemaSeat(showSeatDetails.getCinemaSeat());
        showSeat.setShow(showSeatDetails.getShow());
        showSeat.setBookingId(showSeatDetails.getBookingId());

        return showSeatRepository.save(showSeat);
    }

    @Override
    public void deleteShowSeat(Long showSeatId) throws ResourceNotFoundException {
        ShowSeat showSeat = showSeatRepository.findById(showSeatId)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE + showSeatId));

        showSeatRepository.delete(showSeat);
    }

    @Override
    public ResponseTemplateDto getShowSeatWithBooking(Long id) throws ResourceNotFoundException {

        ShowSeat showSeat = this.getShowSeatById(id);
        BookingDto booking = restTemplate.getForObject("http://booking-service/booking/" + showSeat.getBookingId(), BookingDto.class);

        return new ResponseTemplateDto(showSeat, booking);
    }
}
