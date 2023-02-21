package main.repositories;


import main.model.Event;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface EventRepository  extends MongoRepository<Event, ObjectId> {
}
