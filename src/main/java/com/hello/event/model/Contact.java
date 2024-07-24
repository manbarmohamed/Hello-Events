package com.hello.event.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idC;
    private String name;
    private String email;
    private String message;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "event_id")
private Event event;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
