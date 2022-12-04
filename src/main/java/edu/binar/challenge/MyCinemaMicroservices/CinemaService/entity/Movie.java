package edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movieId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "language", length = 16, nullable = false)
    private String language;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "country", length = 64, nullable = false)
    private String country;

    @Column(name = "genre", length = 20, nullable = false)
    private String genre;

    public enum showingStatus {
        ON_SHOW,
        COMING_SOON
    }

    @Enumerated
    @Column(name = "status", nullable = false)
    private showingStatus status;
}
