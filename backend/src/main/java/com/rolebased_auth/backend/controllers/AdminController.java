package com.rolebased_auth.backend.controllers;
import com.rolebased_auth.backend.entity.Booking;
import com.rolebased_auth.backend.entity.Company;
import com.rolebased_auth.backend.entity.User;
import com.rolebased_auth.backend.repositories.BookingRepository;
import com.rolebased_auth.backend.repositories.CompanyRepository;
import com.rolebased_auth.backend.repositories.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private UserRepository userRepository;
    private CompanyRepository companyRepository;
    private BookingRepository bookingRepository;

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
        return bookingRepository.findAll();
    }
}
