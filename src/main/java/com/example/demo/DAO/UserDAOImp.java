package com.example.demo.DAO;

import com.example.demo.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDAOImp implements UserDAO{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void register(User user) {
        entityManager.merge(user);
    }

    @Override
    public void edit(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.merge(user);
    }


    @Override
    public boolean verify(User user) {
        String query = "FROM User WHERE email=:email AND password=:password";
        List<User> listUser = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .getResultList();

        return !listUser.isEmpty();
    }
}
