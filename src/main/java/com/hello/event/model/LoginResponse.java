package com.hello.event.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LoginResponse {
    @Id
    private Long id;
    String name ;
    String password ;




}
