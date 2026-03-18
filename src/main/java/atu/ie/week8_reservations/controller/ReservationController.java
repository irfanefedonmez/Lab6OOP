package atu.ie.week8_reservations.controller;

import atu.ie.week8_reservations.model.Reservation;
import atu.ie.week8_reservations.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> addReservation(@Valid @RequestBody Reservation reservation) {
        Reservation savedReservation = reservationService.addReservation(reservation);
        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        return new ResponseEntity<>(reservationService.getReservationById(id), HttpStatus.OK);
    }
}