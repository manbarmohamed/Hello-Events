package com.hello.event.repository;

import com.hello.event.model.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {

    @Query("SELECT COUNT(u) FROM User u")
    int countTotalUsers();

    @Query("SELECT COUNT(e) FROM Event e")
    int countTotalEvents();

    @Query("SELECT COUNT(r) FROM Reservation r")
    int countTotalReservations();
}
