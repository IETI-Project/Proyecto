import main.exceptions.UserException;
import main.model.Event;
import main.model.User;
import main.repositories.EventRepository;
import main.repositories.UserRepository;
import main.services.EventServices;
import main.services.UserServices;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class EventTest {
    @InjectMocks
    EventServices manager;

    @Mock
    EventRepository repository;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    //String name, String type, String description, String location, Date date, String host, int capacity,
    //            String priceRange, String locality

    @Test
    public void getAllEvent() throws UserException {
        List<Event> events = new ArrayList<>();
        Event event1 = new Event("Event1", "type1", "Descripcion1", "Chia", new Date(), "messi", 3, "1-2", "Chia2");
        Event event2 = new Event("Event2", "type2", "Descripcion2", "Chia", new Date(), "MessiChiquito", 3, "1-2", "Chia2");
        events.add(event1);
        events.add(event2);
        when(repository.findAll()).thenReturn(events);
        List<Event> eventList = manager.getAllEvents();
        assertEquals(2, eventList.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void getEventById() throws UserException {
        ObjectId id = new ObjectId();
        when(repository.findById(id)).thenReturn(Optional.of(new Event("Event1", "type1", "Descripcion1", "Chia", new Date(), "messi", 3, "1-2", "Chia2")));
        Event event1 = manager.getEventById(id);
        assertEquals(event1.getName(), "Event1");
        assertEquals(event1.getDescription(), "Descripcion1");
    }

    @Test
    public void createEvent() throws UserException {
        Event event1 = new Event("Event1", "type1", "Descripcion1", "Chia", new Date(), "messi", 3, "1-2", "Chia2");
        manager.createEvent(event1);
        verify(repository, times(1)).save(event1);
    }
}
