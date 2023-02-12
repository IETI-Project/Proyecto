package main.persistence;

import java.util.HashMap;

public interface UserPersistence {
    public HashMap<Integer,String> getuserById();

    public void deleteUser(int id);
}
