package com.hello.event.service;

import com.hello.event.enums.Role;
import com.hello.event.exception.UsernameAlreadyTaken;
import com.hello.event.model.User;
import com.hello.event.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.CLIENT);
        return userRepository.save(user);
    }

    public User updateUser(User user, Long id) {
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        userToUpdate.setName(user.getName());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPhone(user.getPhone());
        userToUpdate.setAddress(user.getAddress());
        return userRepository.save(userToUpdate);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found!");
        }
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
