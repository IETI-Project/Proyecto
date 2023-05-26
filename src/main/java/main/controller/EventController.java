package main.controller;


import main.exceptions.EventException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import main.services.EventServices;
import main.model.Event;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"})
@RequestMapping("/v1/events")
public class EventController {
    
    @Autowired
    EventServices eventServices;

    @GetMapping("/all")
    public ResponseEntity<?> getAllEvents(){
        return new ResponseEntity<>(new Gson().toJson(eventServices.getAllEvents()), HttpStatus.ACCEPTED);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getEventByName(@PathVariable String name) throws EventException {
        return new ResponseEntity<>(new Gson().toJson(eventServices.getEventByName(name)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEventById(@PathVariable String id){
        ObjectId objectId = new ObjectId(id);
        return new ResponseEntity<>(new Gson().toJson(eventServices.getEventById(objectId)), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addEvent")
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        eventServices.createEvent(event);
		return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<?> udpateEvent(@PathVariable String id, @RequestBody Event event){
        ObjectId objectId = new ObjectId(id);
		return new ResponseEntity<>(new Gson().toJson(eventServices.updateEvent(objectId, event)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllEvents(){
        eventServices.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @DeleteMapping("{id}")
//    public ResponseEntity<?> deleteEventById(@PathVariable String id){
//        ObjectId objectId = new ObjectId(id);
//        eventServices.deleteEventById(objectId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @DeleteMapping("{event}")
    public ResponseEntity<?> deleteEvent(@PathVariable String event) throws EventException {
        eventServices.deleteEventByName(event);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}