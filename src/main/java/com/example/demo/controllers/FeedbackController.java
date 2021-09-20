package com.example.demo.controllers;


import com.example.demo.DAO.FeedbackDAO;
import com.example.demo.models.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackDAO feedbackDAO;

    @RequestMapping(value="api/feedbacks")
    public List<Feedback> getFeedbacks(){
        return feedbackDAO.getFeedbacks();
    }

    @RequestMapping(value="api/feedbacks", method = RequestMethod.POST)
    public void registerUser(@RequestBody Feedback feedback){
        feedbackDAO.addFeedback(feedback);
    }

    @RequestMapping(value="api/feedbacks/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        feedbackDAO.delete(id);
    }

}
