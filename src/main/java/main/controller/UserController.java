package main.controller;

import com.google.gson.Gson;
import main.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServices us;

    @GetMapping
    public ResponseEntity<?> getUsers(){
        return new ResponseEntity<>(new Gson().toJson(us.getUsers()), HttpStatus.ACCEPTED);
    }
       

}

