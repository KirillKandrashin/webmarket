package com.example.demo.Controller;

import com.example.demo.Entity.User_profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Service.UserProfileService;

import java.util.List;

public class UserProfileController {
    private UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService){
        this.userProfileService = userProfileService;
    }

    @PostMapping(value = "/user_profile")
    public ResponseEntity<?> create(@RequestBody User_profile userProfile){
        userProfileService.create(userProfile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/user_profile")
    public ResponseEntity<List<User_profile>> findAll(){
        final List<User_profile> userProfileList = userProfileService.findAll();

        return userProfileList != null && !userProfileList.isEmpty()
                ? new ResponseEntity<>(userProfileList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user_profile/{id}")
    public ResponseEntity<User_profile> find(@PathVariable(name="id") Long id){
        final User_profile userProfile = userProfileService.find(id);

        return userProfile != null
                ? new ResponseEntity<>(userProfile, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/user_profile")
    public ResponseEntity<?> deleteById(@PathVariable(name="id") Long id) {
        userProfileService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}