package edu.binar.challenge.MyCinemaMicroservices.CinemaService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "showSeats")
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long showSeatId;

    public enum showSeatStatus {
        AVAILABLE,
        SOLD
    }

    @Enumerated
    @Column(name = "status", nullable = false)
    private showSeatStatus status;

    @Column(name = "price", nullable = false)
    private Number price;

    @ManyToOne
    @JoinColumn(name = "cinemaSeatId", nullable = false)
    private CinemaSeat cinemaSeat;

    @ManyToOne
    @JoinColumn(name = "showId", nullable = false)
    private Show show;

    private Long bookingId;
}
