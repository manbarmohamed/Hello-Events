package com.hello.event.controller;

import com.hello.event.model.User;
import com.hello.event.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private UserService userService;

//
//
//  @GetMapping("/{id}")
//  public ResponseEntity<User> getUserById(@PathVariable Long id) {
//    User user = userService.getUserById(id);
//    if (user != null) {
//      return ResponseEntity.ok(user);
//    } else {
//      return ResponseEntity.notFound().build();
//    }
//  }
//
//  @PostMapping
//  public ResponseEntity<User> addUser(@RequestBody User user) {
//    User savedUser = userService.saveUser(user);
//    return ResponseEntity.ok(savedUser);
//  }
//
//  @DeleteMapping("/{id}")
//  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//    try {
//      userService.deleteUser(id);
//      return ResponseEntity.noContent().build();
//    } catch (RuntimeException e) {
//      return ResponseEntity.notFound().build();
//    }
//  }
//
//  @PutMapping("/{id}")
//  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//    try {
//      User updatedUser = userService.updateUser(user, id);
//      return ResponseEntity.ok(updatedUser);
//    } catch (RuntimeException e) {
//      return ResponseEntity.notFound().build();
//    }
//  }

  @GetMapping("/users")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return ResponseEntity.ok(users);
  }

  @PostMapping
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<User> addUser(@RequestBody User user) {
    User savedUser = userService.saveUser(user);
    return ResponseEntity.ok(savedUser);
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    try {
      userService.deleteUser(id);
      return ResponseEntity.noContent().build();
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    try {
      User updatedUser = userService.updateUser(user, id);
      return ResponseEntity.ok(updatedUser);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }
}


