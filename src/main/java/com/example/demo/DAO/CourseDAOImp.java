package com.example.demo.DAO;

import com.example.demo.models.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseDAOImp implements CourseDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Course> getCourses() {
        String query = "FROM Course";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(int id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    @Override
    public void addCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public void edit(int id) {

    }
}
