package com.hello.event.service;


import com.hello.event.exception.EventFullyBookedException;
import com.hello.event.exception.EventNotFoundException;
import com.hello.event.model.Event;
import com.hello.event.model.Reservation;
import com.hello.event.repository.EventRepository;
import com.hello.event.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final EventRepository eventRepository;

    @Transactional
    public Reservation save(Reservation reservation) {
        Event event = eventRepository.findById(reservation.getEvent().getIdE())
                .orElseThrow(() -> new EventNotFoundException("Event not found"));
        if(event.getCapacity()<=0){
            throw new EventFullyBookedException("Event is fully booked");
        }
        event.setCapacity(event.getCapacity()-1);
        eventRepository.save(event);
        return reservationRepository.save(reservation);
    }
}
