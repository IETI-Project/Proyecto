package main.services;

import main.persistence.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class UserServices {
    @Autowired
    private UserPersistence up = null;

    public HashMap<Integer, String> getUsers(){
        return up.getuserById();
    }

    public void deleteUser(int id){
        up.deleteUser(id);
    }
}
