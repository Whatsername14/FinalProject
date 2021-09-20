package com.example.demo.DAO;

import com.example.demo.models.Contact;

import java.util.List;

public interface ContactDAO {

    List<Contact> getContacts();

    void delete(int id);

    void addContact(Contact contact);

    void edit(int id);

    //Contact search(int id);
}
