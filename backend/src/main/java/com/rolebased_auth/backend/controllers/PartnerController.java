package com.rolebased_auth.backend.controllers;
import com.rolebased_auth.backend.entity.Company;
import com.rolebased_auth.backend.entity.Service;
import com.rolebased_auth.backend.repositories.CompanyRepository;
import com.rolebased_auth.backend.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
@RequestMapping("/partner")
public class PartnerController {
    @Autowired
    private CompanyRepository companyRepository;
    private ServiceRepository serviceRepository;

    @PreAuthorize("hasRole('PARTNER')")
    @PostMapping("/company-register")
    public ResponseEntity<?> registerCompany(@Validated @RequestBody Company company, Principal principal) {
        company.setPartnerName(principal.getName());
        companyRepository.save(company);
        return ResponseEntity.ok("Company registered successfully");
    }

    @GetMapping("/my-company")
    public Company getMyCompany(Principal principal) {
        return companyRepository.findByPartnerName(principal.getName());
    }

    @PostMapping("/services")
    public ResponseEntity<?> addService(@RequestBody Service service, Principal principal) {
        Company company = companyRepository.findByPartnerName(principal.getName());
        service.setCompanyId(company.getCompanyId());
        serviceRepository.save(service);
        return ResponseEntity.ok("Service added successfully");
    }
}
