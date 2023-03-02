package main.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

@Document("User")
public class User {
    @Id
    private ObjectId id;
    private String name;
    private String description;

    List<RoleEnum> roles;

    private Date createdAt;

    private String encryptedPassword;

    private String email;

    public User(){
    }
    public User(ObjectId id, String name, String email, String password,String encryptedPassword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.encryptedPassword = new BCryptPasswordEncoder().encode(password);
        this.createdAt = new Date();
        roles = new ArrayList<>(Collections.singleton(RoleEnum.USER));
        this.encryptedPassword = encryptedPassword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, encryptedPassword, createdAt);
    }

}
