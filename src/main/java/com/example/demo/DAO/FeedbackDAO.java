package com.example.demo.DAO;

import com.example.demo.models.Feedback;

import java.util.List;

public interface FeedbackDAO {

    List<Feedback> getFeedbacks();

    void delete(int id);

    void addFeedback(Feedback feedback);

    void edit(int id);
}
