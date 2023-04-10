package main.model;

import main.model.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document("User")
public class User {
    @Id
    private String id;
    private String username;
    private String description;

    Set<Role> roles;

    private Date createdAt;

    private String password;

    private String email;

    public User(){
    }
    public User(String name, String email, String password) {
        this.username = name;
        this.email = email;
        this.password = password;
        this.createdAt = new Date();

    }

    public User(UserDto userDto, String password) {
        this.username = userDto.getName();
        this.email = userDto.getEmail();
        this.password = password;
        this.createdAt = new Date();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String encryptedPassword) {
        this.password = encryptedPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
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
        return Objects.hash(id, username, email, password, createdAt);
    }

}
