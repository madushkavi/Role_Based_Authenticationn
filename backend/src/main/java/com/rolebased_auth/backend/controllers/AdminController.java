package com.rolebased_auth.backend.controllers;
import com.rolebased_auth.backend.entity.Booking;
import com.rolebased_auth.backend.entity.Company;
import com.rolebased_auth.backend.entity.User;
import com.rolebased_auth.backend.repositories.BookingRepository;
import com.rolebased_auth.backend.repositories.CompanyRepository;
import com.rolebased_auth.backend.repositories.UserRepository;
import com.rolebased_auth.backend.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private BookingService bookingService;

    @GetMapping("/users")

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/companies")
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
}
