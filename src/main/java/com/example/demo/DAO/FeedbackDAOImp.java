package com.example.demo.DAO;


import com.example.demo.models.Feedback;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class FeedbackDAOImp implements FeedbackDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Feedback> getFeedbacks() {
        String query = "FROM Feedback";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(int id) {
        Feedback feedback = entityManager.find(Feedback.class, id);
        entityManager.remove(feedback);
    }

    @Override
    public void addFeedback(Feedback feedback) {
        entityManager.merge(feedback);
    }

    @Override
    public void edit(int id) {

    }

}
