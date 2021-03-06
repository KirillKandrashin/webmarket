package com.example.demo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;

    private String email;
    private String password;
    private Boolean is_active; // подтвердил ли почту

    @OneToOne(targetEntity = User_profile.class)
    private User_profile user_profile;
    @ManyToOne
    private Role role_id;


}