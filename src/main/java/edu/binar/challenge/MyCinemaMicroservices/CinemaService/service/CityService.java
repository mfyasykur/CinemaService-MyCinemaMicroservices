package edu.binar.challenge.MyCinemaMicroservices.CinemaService.service;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.City;
import edu.binar.challenge.MyCinemaMicroservices.CinemaService.exception.ResourceNotFoundException;

import java.util.List;

public interface CityService {

    List<City> getAllCities();
    City getCityById(Long cityId) throws ResourceNotFoundException;
    City createCity(City city);
    City updateCity(Long cityId, City city) throws ResourceNotFoundException;
    void deleteCity(Long cityId) throws ResourceNotFoundException;
}
