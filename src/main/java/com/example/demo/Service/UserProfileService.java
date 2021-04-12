package com.example.demo.Service;

import com.example.demo.Entity.User_profile;
import com.example.demo.Repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    public void create(User_profile userProfile){
        userProfileRepository.save(userProfile);
    }

    public List<User_profile> findAll(){
        return userProfileRepository.findAll();
    }

    public User_profile find(Long id){
        return userProfileRepository.getOne(id);
    }

    public void delete(Long id){ userProfileRepository.deleteById(id); }

}