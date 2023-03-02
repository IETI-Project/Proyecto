import main.exceptions.UserException;
import main.model.User;
import main.repositories.UserRepository;
import main.services.UserServices;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserTest {
    @InjectMocks
    UserServices manager;

    @Mock
    UserRepository repository;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllUser() throws UserException {
        List<User> users = new ArrayList<>();
        User user1 = new User("User1", "Descripcion1");
        User user2 = new User("User2", "Descripcion2");
        users.add(user1);
        users.add(user2);
        when(repository.findAll()).thenReturn(users);
        List<User> userList = manager.getAllUsers();
        assertEquals(2, userList.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void getUserById() throws UserException {
        ObjectId id = new ObjectId();
        when(repository.findById(id)).thenReturn(Optional.of(new User("User2", "Descripcion2")));
        User user1 = manager.getUserById(id).get();
        assertEquals(user1.getName(), "User2");
        assertEquals(user1.getDescription(), "Descripcion2");
    }

    @Test
    public void createUser() throws UserException {
        User user1 = new User("User1", "Descripcion1");
        manager.createUser(user1);
        verify(repository, times(1)).save(user1);
    }
}
