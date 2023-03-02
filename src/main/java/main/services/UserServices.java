package main.services;

import main.exceptions.UserException;
import main.model.User;
import main.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(ObjectId id) throws UserException {
        try {
            return userRepository.findById(id);
        }
        catch(Exception e){
            throw new UserException(UserException.USER_NOT_FOUND_EXCEPTION);
        }
    }

    public List<User> getAllUsers() throws UserException {
        return userRepository.findAll();
    }

    public User createUser(User user) throws UserException {
        try {
            return userRepository.save(user);
        }
        catch(Exception e){
            throw new UserException(UserException.USER_NOT_CREATED_EXCEPTION);
        }
    }

    public User updateUser(User user) throws UserException {
        try {
            return userRepository.save(user);
        }
        catch (Exception e){
            throw new UserException(UserException.USER_NOT_UPDATE_EXCEPTION);
        }

    }

    public void deleteUser(ObjectId id) throws UserException {
        try {
            userRepository.deleteById(id);
        }
        catch (Exception e){
            throw new UserException(UserException.USER_NOT_DELETED_EXCEPTION);
        }
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
