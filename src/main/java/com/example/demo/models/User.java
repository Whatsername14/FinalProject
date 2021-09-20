package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Getter @Setter @Column(name="user_id")
    private int userId;

    @Getter @Setter @Column(name="name")
    private String name;

    @Getter @Setter @Column(name="email")
    private String email;

    @Getter @Setter @Column(name="password")
    private String password;

    @Getter @Setter @Column(name="phone")
    private String phone;

    @Getter @Setter @Column(name="address")
    private String address;


}
