package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Feedback")
public class Feedback {

    @Id
    @Getter @Setter @Column(name="feedback_id")
    private int feedbackId;

    @Getter @Setter @Column(name="name")
    private String name;

    @Getter @Setter @Column(name="email")
    private String email;

    @Getter @Setter @Column(name="feedback")
    private String feedback;

    @Getter @Setter @Column(name="user_id")
    private int userId;

}
