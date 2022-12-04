package edu.binar.challenge.MyCinemaMicroservices.CinemaService.repository;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaHallRepository extends JpaRepository<CinemaHall, Long> {
}
