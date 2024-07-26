package com.hello.event.service;

import com.hello.event.model.Dashboard;
import com.hello.event.repository.DashboardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DashboardService {

    private final DashboardRepository dashboardRepository;

    public DashboardService(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public Dashboard getDashboard() {
        Dashboard dashboard = new Dashboard();
        dashboard.setTotalUsers(dashboardRepository.countTotalUsers());
        dashboard.setTotalEvents(dashboardRepository.countTotalEvents());
        dashboard.setTotalReservations(dashboardRepository.countTotalReservations());
        return dashboard;
    }
}
