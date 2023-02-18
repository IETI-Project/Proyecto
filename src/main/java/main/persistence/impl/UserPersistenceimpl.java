package main.persistence.impl;

import main.model.User;
import main.persistence.UserPersistence;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.HashMap;

@Component
public class UserPersistenceimpl implements UserPersistence {

    private HashMap<Integer, User> users = new HashMap<>();

    public UserPersistenceimpl(){
        //This is a example of the user's collection
        User userOne = new User(1,"Valentina","Estudiante");
        User userTwo = new User(2, "Carlos","Estudiante");

        users.put(1,userOne);
        users.put(2,userTwo);
    }

    @Override
    public HashMap<Integer, User> getAllUsers() {
        return users;
    }

    @Override
    public User createUser(User user) {
       return users.put(user.getId(),new User(user.getId(),user.getName(),user.getDescription()));
    }

    @Override
    public User updateUser(User user, Integer newId) {
        users.remove(users.remove(newId));
        return users.put(newId, user);
    }
        
    @Override   
    public void deleteUser(int id){
        users.remove(id);
    }


}
