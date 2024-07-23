package com.hello.event.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
<<<<<<< HEAD
@ToString
=======
>>>>>>> 5cc5f87494cd9d05a7c16c9b8d7b342a3a834592
public class LoginResponse {
    @Id
    private Long id;
    String name ;
    String password ;




}
