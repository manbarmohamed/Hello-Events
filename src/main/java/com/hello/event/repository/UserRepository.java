package com.hello.event.repository;

import com.hello.event.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<Object> findByName(String username);

}
