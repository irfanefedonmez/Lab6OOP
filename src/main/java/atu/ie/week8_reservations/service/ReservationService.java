package atu.ie.week8_reservations.service;

import atu.ie.week8_reservations.exception.ReservationConflictException;
import atu.ie.week8_reservations.exception.ReservationNotFoundException;
import atu.ie.week8_reservations.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private final List<Reservation> reservations = new ArrayList<>();
    private long nextId = 1;

    public Reservation addReservation(Reservation reservation) {
        int newStart = reservation.getStartHour();
        int newEnd = reservation.getStartHour() + reservation.getDurationHours();

        for (Reservation existing : reservations) {
            boolean sameEquipment = existing.getEquipmentTag().equalsIgnoreCase(reservation.getEquipmentTag());
            boolean sameDate = existing.getReservationDate().equals(reservation.getReservationDate());

            int existingStart = existing.getStartHour();
            int existingEnd = existing.getStartHour() + existing.getDurationHours();

            boolean overlap = existingStart < newEnd && newStart < existingEnd;

            if (sameEquipment && sameDate && overlap) {
                throw new ReservationConflictException("Reservation conflict: equipment is already booked for that time.");
            }
        }

        reservation.setReservationId(nextId++);
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }

    public Reservation getReservationById(Long id) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId().equals(id)) {
                return reservation;
            }
        }
        throw new ReservationNotFoundException("Reservation with id " + id + " not found.");
    }
}