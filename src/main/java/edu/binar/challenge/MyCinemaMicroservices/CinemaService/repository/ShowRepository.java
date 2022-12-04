package edu.binar.challenge.MyCinemaMicroservices.CinemaService.repository;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}
