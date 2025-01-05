package com.rolebased_auth.backend.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "companies")
public class Company {
    @Id
    private String id;
    private String name;
    private  String address;
    private  String contactInfo;
    private String partnerName ;

    public void setPartnerName(String partnerName) {
        this.partnerName=partnerName;
    }

    public String getCompanyId() {
        return id ;
    }
}
