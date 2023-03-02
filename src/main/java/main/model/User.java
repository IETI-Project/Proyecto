package main.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("User")
public class User {
    @Id
    private ObjectId id;
    private String name;
    private String description;

    public User(){
    }
    public User(String name, String description){
        this.name=name;
        this.description = description;
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

}
