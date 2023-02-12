package main.persistence.impl;

import main.persistence.UserPersistence;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.HashMap;

@Component
public class UserPersistenceimpl implements UserPersistence {

    private HashMap<Integer, String> users = new HashMap<>();

    @Override
    public HashMap<Integer, String> getuserById() {
        return users;
    }

    @Override
    public void deleteUser(int id){
        users.remove(id);
    }


}
