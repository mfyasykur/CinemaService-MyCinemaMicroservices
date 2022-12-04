package edu.binar.challenge.MyCinemaMicroservices.CinemaService.repository;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
