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
    private String price;
    private String companyId;

    public void setCompanyId(String companyId) {
        this.companyId= companyId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getServiceName() {
        return serviceName ;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription(){
        return description ;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
