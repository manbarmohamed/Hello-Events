package com.hello.event.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import com.hello.event.enums.Category;
import com.hello.event.model.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idE;
    private String name;
    private String description;
    private LocalDateTime dateTime;
    private String location ;
    private Integer capacity;
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 225)
    private Category category;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Reservation> reservations;


}
