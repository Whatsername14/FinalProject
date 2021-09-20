package com.example.demo.DAO;

import com.example.demo.models.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();

    void delete(int id);

    void register(User user);

    void edit(int id);

    boolean verify(User user);
}
