package edu.binar.challenge.MyCinemaMicroservices.CinemaService.repository;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
