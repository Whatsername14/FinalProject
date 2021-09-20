package com.example.demo.controllers;

import com.example.demo.DAO.UserDAO;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAO userdao;

    @RequestMapping(value="api/users")
    public List<User> getUsers(){
        return userdao.getUsers();
    }

    @RequestMapping(value="api/users/{id}")
    public User search(@PathVariable int id){
        User user = new User();
        user.setUserId(id);
        user.setName("Andrea");
        user.setEmail("prueba@emailcom");
        user.setPassword("pass123");
        user.setPhone("12345678");
        user.setAddress("Aqui 123");
        return user;
    }

    @RequestMapping(value="api/users", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user){
        userdao.register(user);
    }

    @RequestMapping(value="api/users/{id}", method = RequestMethod.POST)
    public User edit(){
        User user = new User();
        user.setName("Andrea");
        user.setEmail("prueba@emailcom");
        user.setPassword("pass123");
        user.setPhone("12345678");
        user.setAddress("Aqui 123");
        return user;
    }

    @RequestMapping(value="api/users/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        userdao.delete(id);
    }

}
