package com.hello.event.service;

import com.hello.event.dto.AuthRequestDTO;
import com.hello.event.dto.JwtResponseDTO;
import com.hello.event.model.User;
import com.hello.event.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Lazy
    @Autowired
    private JwtService jwtService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getName())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }

    public JwtResponseDTO signUp(User userRequest) {
        if (userRepository.findByUsername(userRequest.getName()) != null) {
            throw new RuntimeException("Username is already taken.");
        }

        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        User savedUser = userRepository.save(userRequest);
        String token = jwtService.generateToken(savedUser.getName(),savedUser.getRole());

        return JwtResponseDTO.builder()
                .accessToken(token)
                .user(savedUser)
                .build();
    }

    public JwtResponseDTO login(AuthRequestDTO authRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword())
        );

        if (authentication.isAuthenticated()) {
            User user =userRepository.findByUsername(authRequestDTO.getUsername());
            String token = jwtService.generateToken(user.getName(),user.getRole());

            return JwtResponseDTO.builder()
                    .accessToken(token)
                    .user(user)
                    .build();
        } else {
            throw new UsernameNotFoundException("Invalid user request.");
        }
    }
}
