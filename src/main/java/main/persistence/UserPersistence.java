package main.persistence;

import main.model.User;

import java.util.HashMap;

public interface UserPersistence {

    public HashMap<Integer, User> getAllUsers();

    User createUser(User user);

    User updateUser(User user, Integer id);
    
    public void deleteUser(int id);

}
