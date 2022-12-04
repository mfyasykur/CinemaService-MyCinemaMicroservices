package edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long showId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "startTime", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "endTime", nullable = false)
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "cinemaHallId", nullable = false)
    private CinemaHall cinemaHall;

    @ManyToOne
    @JoinColumn(name = "movieId", nullable = false)
    private Movie movie;
}
