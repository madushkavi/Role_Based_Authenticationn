package com.rolebased_auth.backend.controllers;
import com.rolebased_auth.backend.entity.Booking;
import com.rolebased_auth.backend.entity.Service;
import com.rolebased_auth.backend.repositories.BookingRepository;
import com.rolebased_auth.backend.repositories.ServiceRepository;
import com.rolebased_auth.backend.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/client")

public class ClientController {
    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private ServiceRepository serviceRepository;

    @PreAuthorize("hasRole('CLIENT')")
    @PostMapping("/book-service")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking, Principal principle){
        booking.setClientId(principle.getName());
        booking.setStatus("pending");
        bookingRepository.save(booking);
        return ResponseEntity.ok("Service booked successfully");
    }
    @PreAuthorize("hasRole('CLIENT')")
    @GetMapping("/services")
    public List<Service> getAllServices(){
        return serviceRepository.findAll();
    }
    @GetMapping("/my-bookings")
    public List<Booking> getMyBookings(Principal principal) {
        return bookingRepository.findByClientId(principal.getName());
    }
}
