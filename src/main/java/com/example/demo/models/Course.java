package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @Getter @Setter @Column(name="course_id")
    private int courseId;

    @Getter @Setter @Column(name="course_name")
    private String courseName;

    @Getter @Setter @Column(name="course_resource")
    private String courseResource;

    @Getter @Setter @Column(name="course_fee")
    private String courseFee;

    @Getter @Setter @Column(name="course_desc")
    private String courseDescription;


}
