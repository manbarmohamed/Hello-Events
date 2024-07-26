package com.hello.event.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
    @Data
    public class Dashboard {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idD;
        private int totalUsers;
        private int totalEvents;
        private int totalReservations;
}
