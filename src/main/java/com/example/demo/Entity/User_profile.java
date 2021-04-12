package com.example.demo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
public class User_profile{
    @Id
    @OneToOne(targetEntity = User.class)
    private User user;

    private String first_name;
    private String last_name;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date birthday;

    private String city;
    private String street;
    private String house;
    private String floor;
    private String flat;

}