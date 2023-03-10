package main.controller;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import main.services.EventServices;
import main.model.Event;

@RestController
@RequestMapping("/events")
public class EventController {
    
    @Autowired
    EventServices eventServices;

    @GetMapping()
    public ResponseEntity<?> getAllEvents(){
        return new ResponseEntity<>(new Gson().toJson(eventServices.getAllEvents()), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEventById(@PathVariable ObjectId id){
        return new ResponseEntity<>(new Gson().toJsonTree(eventServices.getEventById(id)), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addEvent")
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        eventServices.createEvent(event);
		return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<?> createEvent(@PathVariable ObjectId id, @RequestBody Event event){
		return new ResponseEntity<>(new Gson().toJson(eventServices.updateEvent(id, event)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllEvents(){
        eventServices.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEventById(@PathVariable ObjectId id){
        eventServices.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{event}")
    public ResponseEntity<?> deleteEvent(@PathVariable Event event){
        eventServices.deleteEvent(event);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}