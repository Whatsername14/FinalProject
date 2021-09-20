package com.example.demo.DAO;

import com.example.demo.models.Course;

import java.util.List;

public interface CourseDAO {

    List<Course> getCourses();

    void delete(int id);

    void addCourse(Course course);

    void edit(int id);
}
