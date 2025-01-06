package com.rolebased_auth.backend.controllers;
import com.rolebased_auth.backend.entity.Company;
import com.rolebased_auth.backend.entity.ComService;
import com.rolebased_auth.backend.repositories.CompanyRepository;
import com.rolebased_auth.backend.repositories.ComServiceRepository;
import com.rolebased_auth.backend.services.ComServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/partner")
public class PartnerController {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ComServiceService comServiceService;

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
    public ResponseEntity<?> addService(@RequestBody ComService comService, Principal principal) {
        Company company = companyRepository.findByPartnerName(principal.getName());
        comService.setCompanyId(company.getCompanyId());
        comServiceService.addService(comService);
        return ResponseEntity.ok("Service added successfully");
    }
    @GetMapping("/services")
    public ResponseEntity<?> getServices(Principal principal) {
        Company company = companyRepository.findByPartnerName(principal.getName());
        if (company == null) {
            return ResponseEntity.badRequest().body("No company found for the logged-in partner");
        }
        List<ComService> services = comServiceService.findByCompanyId(company.getCompanyId());
        return ResponseEntity.ok(services);
    }

}
