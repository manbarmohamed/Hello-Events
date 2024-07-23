package com.hello.event.model;

import jakarta.persistence.*;
import lombok.*;
import com.hello.event.enums.Category;
import com.hello.event.model.*;


import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idE;
    private String name;
    private String description;
    private LocalDateTime dateTime;
    private String location ;
    private String capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 225)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "reservation_id" , nullable = false)
    private Reservation reservation;



}
