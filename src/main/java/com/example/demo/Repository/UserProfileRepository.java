package com.example.demo.Repository;

import com.example.demo.Entity.User_profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<User_profile,Long> {
}

