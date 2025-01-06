package com.rolebased_auth.backend.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "services")
public class ComService {
    @Id
    private String id;
    private String serviceName;
    private String description;
    private Double price;
    private String companyId;

    public void setCompanyId(String companyId) {
        this.companyId= companyId;
    }
}
