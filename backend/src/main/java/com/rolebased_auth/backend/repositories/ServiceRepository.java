package com.rolebased_auth.backend.repositories;

import com.rolebased_auth.backend.entity.Service;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServiceRepository extends MongoRepository<Service,String> {
    default List<Service> findAll() {
        return null;
    }
}
