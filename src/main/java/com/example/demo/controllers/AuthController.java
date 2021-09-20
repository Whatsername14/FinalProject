package com.example.demo.controllers;

import com.example.demo.DAO.UserDAO;
import com.example.demo.models.User;
import com.example.demo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserDAO userdao;


    @RequestMapping(value="api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user){

        if(userdao.verify(user)){
            return "OK";
        }
        return "Fail";
    }

}
