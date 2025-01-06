package com.rolebased_auth.backend.repositories;

import com.rolebased_auth.backend.entity.ComService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComServiceRepository extends MongoRepository<ComService,String> {

    List<ComService> findByCompanyId(String companyId);
}
