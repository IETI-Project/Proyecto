package main.controller;

import com.google.gson.Gson;
import main.model.User;
import main.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping()
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(new Gson().toJson(userServices.getAllUsers()), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        System.out.println(user.toString());
        userServices.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/addUser/{id}/{name}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Integer id,@PathVariable String name){
        userServices.updateUser(user,id,name);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id){
        userServices.deleteUser(id);
        return ResponseEntity.ok().build();
    }
       

}

