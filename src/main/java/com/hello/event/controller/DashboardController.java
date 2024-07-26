package com.hello.event.controller;

import com.hello.event.model.Dashboard;
import com.hello.event.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class DashboardController {

    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public Dashboard getDashboardMetrics() {
        return dashboardService.getDashboard();
    }
}
