package com.rolebased_auth.backend.services;

import com.rolebased_auth.backend.repositories.ComServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.rolebased_auth.backend.entity.ComService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComServiceService {
    @Autowired
    private ComServiceRepository comServiceRepository;

    public void addService(ComService comService){
        comServiceRepository.save(comService);
    }
    public List<ComService> findByCompanyId(String companyId){
        return comServiceRepository.findByCompanyId(companyId);
    }

}
