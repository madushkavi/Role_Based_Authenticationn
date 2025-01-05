package com.rolebased_auth.backend.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection =  "users")
public class User {
    @Id
    private String id;

    @Field("userName")
    private String userName;
    @Field("password")
    private String password;
    @Field("role")
    private String role;  // partner,client,superadmin

    public String getUserName() {
        return userName;
    }
    public void setPassword(String password) {
        this.password=password;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role=role ;
    }
}
