package main.services;

import main.model.Event;
import main.repositories.EventRepository;
import main.exceptions.EventException;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

@EnableMongoRepositories(basePackageClasses = EventRepository.class)
@Service
public class EventServices {

    @Autowired
    EventRepository eventRepository;

    public Event getEventById(ObjectId id){
        return eventRepository.findById(id).get();
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event getEventByName(String name) throws EventException{
        for(Event e : eventRepository.findAll()){
            if(e.getName().equals(name)){
                return e;
            }
        }
        throw new EventException(EventException.EVENT_NOT_FOUND_EXCEPTION);
    }

    public ArrayList<Event> getEventsByLoclity(String locality) throws EventException{
        ArrayList<Event> events =  new ArrayList();
        for(Event e: eventRepository.findAll()){
            if(e.getLocality().equals(locality)){
                events.add(e);
            }
        }
        if (events.isEmpty()){
            throw new EventException(EventException.EVENT_NOT_FOUND_EXCEPTION);
        }
        return events;
    }

    public Event createEvent(Event event){
        eventRepository.save(event);
        return event;
    }

    public void deleteEvent(Event event){
        eventRepository.delete(event);
    }

    public void deleteEventById(ObjectId id){
        eventRepository.deleteById(id);
    }

    public void deleteAll(){
        eventRepository.deleteAll();
    }

    public Event updateEvent(ObjectId id, Event newEvent){
        Event event = eventRepository.findById(id).get();
        event.update(newEvent);
        eventRepository.save(event);
        return event;
    }

}
