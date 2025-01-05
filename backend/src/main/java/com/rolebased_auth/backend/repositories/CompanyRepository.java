package com.rolebased_auth.backend.repositories;

import com.rolebased_auth.backend.entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends MongoRepository<Company,String> {
    Company findByPartnerName(String partnerName);
}
