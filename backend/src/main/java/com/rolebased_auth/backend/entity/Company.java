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

    public String getPartnerName() {
        return partnerName;
    }

    public String getCompanyId() {
        return id ;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
