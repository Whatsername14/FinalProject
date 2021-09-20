package com.example.demo.DAO;

import com.example.demo.models.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class ContactDAOImp implements ContactDAO{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Contact> getContacts() {
        String query = "FROM Contact";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(int id) {
        Contact contact = entityManager.find(Contact.class, id);
        entityManager.remove(contact);
    }

    @Override
    public void addContact(Contact contact) {
        entityManager.merge(contact);
    }

    @Override
    public void edit(int id) {

    }

   /* @Override
    public Contact search(int id) {
        String query = "FROM Contact WHERE contact_id=:contact_id";
        //return entityManager.createQuery(query).getResultList();
    }*/

}
