package com.hello.event.dto;

import com.hello.event.enums.Role;
import com.hello.event.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponseDTO {
    private String accessToken;
    private String username;
}