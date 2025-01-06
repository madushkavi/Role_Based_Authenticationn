package com.rolebased_auth.backend.repositories;

import com.rolebased_auth.backend.entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking,String> {
    List<Booking> findByClientId(String clientId);

}
