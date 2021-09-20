package com.example.demo.controllers;

import com.example.demo.DAO.CourseDAO;
import com.example.demo.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseDAO courseDAO;

    @RequestMapping(value="api/courses")
    public List<Course> getCourses(){
        return courseDAO.getCourses();
    }

    @RequestMapping(value="api/courses", method = RequestMethod.POST)
    public void addContact(@RequestBody Course course){
        courseDAO.addCourse(course);
    }

    @RequestMapping(value="api/courses/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        courseDAO.delete(id);
    }

}
