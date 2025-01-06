package com.rolebased_auth.backend.services;

import com.rolebased_auth.backend.entity.Booking;
import com.rolebased_auth.backend.repositories.BookingRepository;
import com.rolebased_auth.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
@Autowired
   private  UserRepository userRepository;
@Autowired
    private BookingRepository bookingRepository;

public Booking createBooking(Booking booking){
    return bookingRepository.save(booking);
}
public List<Booking> getAllBookings() {
    return bookingRepository.findAll() ;
}
public Optional<Booking> findByBookingId(String id){
    return bookingRepository.findById(id) ;
}

public List <Booking> findByClientId(String clientId){
    return bookingRepository.findByClientId(clientId) ;
}

}
