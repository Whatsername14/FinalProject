package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contact")
public class Contact {

    @Id
    @Getter @Setter @Column(name="contact_id")
    private int contactId;

    @Getter @Setter @Column(name="name")
    private String name;

    @Getter @Setter @Column(name="phone")
    private String phone;

    @Getter @Setter @Column(name="email")
    private String email;

    @Getter @Setter @Column(name="message")
    private String message;

    @Getter @Setter @Column(name="user_id")
    private int userId;

}
