package com.rolebased_auth.backend.services;

import com.rolebased_auth.backend.entity.Company;
import com.rolebased_auth.backend.entity.User;
import com.rolebased_auth.backend.repositories.CompanyRepository;
import com.rolebased_auth.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompanyRepository companyRepository;

    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company registerCompany(Company company, String partnerName){
        User partner = userRepository.findByUserName (partnerName)
                .orElseThrow(()-> new RuntimeException("Partner not found"));

        if(!"Partner".equals(partner.getRole())){
            throw new RuntimeException("User is not a partner");
        }
        company.setPartnerName(partnerName);
        return companyRepository.save(company);
    }
}
