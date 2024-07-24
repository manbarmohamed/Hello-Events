package com.hello.event.controller;

import com.hello.event.dto.AuthRequestDTO;
import com.hello.event.dto.JwtResponseDTO;
import com.hello.event.enums.Role;
import com.hello.event.model.User;
import com.hello.event.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/api/auth")
////@CrossOrigin(origins = "http://localhost:4200")
//public class AuthController {
//
//    @Autowired
//    private UserAuthService userAuthService;
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@RequestBody User user) {
//        try {
//            // Assume signUp method returns a User with appropriate role set
//            JwtResponseDTO registeredUser = userAuthService.signUp(user);
//            return ResponseEntity.ok(registeredUser);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody AuthRequestDTO authRequestDTO) {
//        try {
//            JwtResponseDTO jwtResponseDTO = userAuthService.login(authRequestDTO);
//            return ResponseEntity.ok(jwtResponseDTO);
//        } catch (UsernameNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
//}
@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final UserAuthService userAuthService;

    @Autowired
    public AuthController(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
//            user.setRole(Role.CLIENT);
            JwtResponseDTO registeredUser = userAuthService.signUp(user);
            return ResponseEntity.ok(registeredUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO authRequestDTO) {
        try {

            JwtResponseDTO jwtResponseDTO = userAuthService.login(authRequestDTO);
            return ResponseEntity.ok(jwtResponseDTO);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
