package com.rolebased_auth.backend.repositories;

import com.rolebased_auth.backend.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByUserName(String userName);

}
