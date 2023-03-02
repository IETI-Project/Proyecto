package main.controller;

import com.google.gson.Gson;
import main.exceptions.UserException;
import main.model.User;
import main.model.dto.UserDto;
import main.services.UserServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("v1/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@RequestBody String id) throws UserException {
        ObjectId objectId = new ObjectId(id);
        userServices.deleteUser(objectId);
        return new ResponseEntity<>(new Gson().toJson(userServices.getUserById(objectId)), HttpStatus.ACCEPTED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllUsers() throws UserException {
        return new ResponseEntity<>(new Gson().toJson(userServices.getAllUsers()), HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody UserDto user) throws UserException {
        userServices.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user) throws UserException {
        userServices.updateUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")

    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) throws UserException {
        ObjectId objectId = new ObjectId(id);
        userServices.deleteUser(objectId);
        return ResponseEntity.ok().build();
    }
       

}

