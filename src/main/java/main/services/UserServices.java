package main.services;

import main.model.User;
import main.persistence.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class UserServices {
    @Autowired
    private UserPersistence up;

    public HashMap<Integer, User> getAllUsers(){
        return up.getAllUsers();
    }

    public User createUser(User user){
        return up.createUser(user);
    }
}
