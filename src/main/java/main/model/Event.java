package main.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Date;

@Document("Event")
public class Event {

    @Id
    private ObjectId id;
    private String name;
    private String type;
    private String description;
    private String location;
    private Date date;
    private String host;
    private int capacity;
    private String priceRange;
    private String locality;



    @JsonCreator
    public Event(@JsonProperty("name")String name, @JsonProperty("type")String type, @JsonProperty("description")String description, @JsonProperty("location")String location, 
            @JsonProperty("date")Date date, @JsonProperty("host")String host, @JsonProperty("capacity")int capacity,
            @JsonProperty("priceRange")String priceRange, @JsonProperty("locality")String locality) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.location = location;
        this.date = date;
        this.host = host;
        this.capacity = capacity;
        this.priceRange = priceRange;
        this.locality = locality;
    }

    @JsonCreator
    public Event(@JsonProperty("name")String name,@JsonProperty("description")String description){
        this.name=name;
        this.description=description;
    }

    

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    
    public void update(Event newEvent) {
        this.name = newEvent.getName();
        this.type = newEvent.getType();
        this.description = newEvent.getDescription();
        this.location = newEvent.getLocation();
        this.date = newEvent.getDate();
        this.host = newEvent.getHost();
        this.capacity = newEvent.getCapacity();
        this.priceRange = newEvent.getPriceRange();
        this.locality = newEvent.getLocality();
    }
   
}
