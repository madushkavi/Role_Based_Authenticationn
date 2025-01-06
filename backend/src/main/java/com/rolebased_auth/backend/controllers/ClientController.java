package com.rolebased_auth.backend.controllers;
import com.rolebased_auth.backend.entity.Booking;
import com.rolebased_auth.backend.entity.ComService;
import com.rolebased_auth.backend.repositories.BookingRepository;
import com.rolebased_auth.backend.repositories.ComServiceRepository;
import com.rolebased_auth.backend.repositories.UserRepository;
import com.rolebased_auth.backend.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/client")

public class ClientController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ComServiceRepository comServiceRepository;


    @PostMapping("/book-service")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking, Principal principle){
        booking.setClientId(principle.getName());
        booking.setStatus("pending");
        bookingService.createBooking(booking);
        return ResponseEntity.ok("Service booked successfully");
    }
    @GetMapping("/services")
    public List<ComService> getAllServices(){

        return comServiceRepository.findAll();
    }
    @GetMapping("/my-bookings")
    public List<Booking> getMyBookings(Principal principal) {
        return bookingService.findByClientId(principal.getName());
    }
}
