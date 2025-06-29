package com.BusBookingApplication;

import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.BusBookingApplication.entity.Bus;
import com.BusBookingApplication.entity.Route;
import com.BusBookingApplication.entity.User;
import com.BusBookingApplication.service.BusService;
import com.BusBookingApplication.service.RouteService;
import com.BusBookingApplication.service.UserService;

@SpringBootApplication
public class BusBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusBookingApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(UserService userService, BusService busService, RouteService routeService) {
        return args -> {
            if (userService.getUserByEmail("user@example.com").isEmpty()) {
                User mockUser = new User("John Doe", "user@example.com", "password123", "ROLE_USER");
                userService.registerUser(mockUser);
                System.out.println("Mock user created: user@example.com / password123");
            }

            if (routeService.getAllRoutes().isEmpty()) {
                System.out.println("Populating mock bus and route data...");
                Bus bus1 = busService.saveBus(new Bus("KA01-A1234", 40, "AC", "Swift Travels"));
                Bus bus2 = busService.saveBus(new Bus("TN02-B5678", 35, "Non-AC", "Blue Line"));
                Bus bus3 = busService.saveBus(new Bus("KL03-C9012", 50, "Sleeper", "Green Express"));

                if (bus1 != null && bus2 != null && bus3 != null) {
                    routeService.saveRoute(new Route("Mumbai", "Chennai", LocalTime.of(8, 0), LocalTime.of(15, 0), 750.0, bus1));
                    routeService.saveRoute(new Route("Bangalore", "Goa", LocalTime.of(10, 0), LocalTime.of(17, 0), 820.0, bus2));
                    routeService.saveRoute(new Route("Delhi", "Coimbatore", LocalTime.of(9, 30), LocalTime.of(16, 30), 600.0, bus3));
                    routeService.saveRoute(new Route("Noida", "Meerut", LocalTime.of(7, 0), LocalTime.of(14, 0), 900.0, bus1));
                    System.out.println("Mock routes created.");
                } else {
                    System.err.println("Failed to save one or more mock buses. Routes might not be created.");
                }
            }
        };
    }
}
