package com.hello.event.controller;


import com.hello.event.model.Contact;
import com.hello.event.model.Reservation;
import com.hello.event.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @PreAuthorize("hasRole('CLIENT')")
    @PostMapping("/add")
    public ResponseEntity<Reservation> save(@RequestBody Reservation reservation) {
        try {
            Reservation savedReservation = reservationService.save(reservation);
            return ResponseEntity.ok(savedReservation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

}
