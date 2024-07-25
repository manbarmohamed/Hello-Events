package com.hello.event.controller;


import com.hello.event.model.Reservation;
import com.hello.event.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping("/add")
    public ResponseEntity<Reservation> save(Reservation reservation) {
        return ResponseEntity.ok(reservationService.save(reservation));
    }

}
