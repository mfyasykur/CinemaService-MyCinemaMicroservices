package edu.binar.challenge.MyCinemaMicroservices.CinemaService.repository;

import edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity.CinemaSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaSeatRepository extends JpaRepository<CinemaSeat, Long> {
}
