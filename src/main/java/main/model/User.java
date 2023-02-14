package main.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class User {
    private int id;
    private String name;
    private String description;

    @JsonCreator
    public User(@JsonProperty("id")int id,@JsonProperty("name")String name,@JsonProperty("description")String description){
        this.id=id;
        this.name=name;
        this.description=description;
    }
    public User(int id,String name){
        this.id=id;
        this.name=name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
