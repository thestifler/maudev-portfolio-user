package maudev.portfolio.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import maudev.portfolio.user.entity.User;
import maudev.portfolio.user.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    
    @Autowired
    private  UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){


        User userDB = userService.createUser(user);

        if(userDB == null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(userDB);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(name = "id") Long id , @RequestBody User user){
        user.setId(id);

        User userDB = userService.updateUser(user);

        if (userDB == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(userDB);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "id") Long id){
        User userDB = userService.deleteUser(id);

        if (userDB == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(userDB);
    }
}
