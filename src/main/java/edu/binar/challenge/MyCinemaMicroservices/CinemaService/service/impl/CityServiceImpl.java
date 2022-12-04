package edu.binar.challenge.MyCinemaMicroservices.CinemaService.service.impl;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.City;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.repository.CityRepository;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    private static final String MESSAGE = "CinemaHall not found for this id :: ";

    @Override
    public City getCityById(Long cityId) throws ResourceNotFoundException {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE + cityId));

        return cityRepository.save(city);
    }

    @Override
    public City createCity(City city){
        return cityRepository.save(city);
    }

    @Override
    public City updateCity(Long cityId, City cityDetails) throws ResourceNotFoundException {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE + cityId));

        city.setName(cityDetails.getName());
        city.setState(cityDetails.getState());
        city.setZipCode(cityDetails.getZipCode());

        return cityRepository.save(city);
    }

    @Override
    public void deleteCity(Long cityId) throws ResourceNotFoundException {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException(MESSAGE + cityId));

        cityRepository.delete(city);
    }
}
