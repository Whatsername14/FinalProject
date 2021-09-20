package com.example.demo.controllers;

import com.example.demo.DAO.ContactDAO;
import com.example.demo.models.Contact;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactDAO contactDAO;

    @RequestMapping(value="api/contacts")
    public List<Contact> getContacts(){
        return contactDAO.getContacts();
    }

    @RequestMapping(value="api/contacts", method = RequestMethod.POST)
    public void addContact(@RequestBody Contact contact){
        contactDAO.addContact(contact);
    }

    @RequestMapping(value="api/contacts/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        contactDAO.delete(id);
    }

    /*
    @RequestMapping(value="api/contacts/{id}")
    public Contact search(@PathVariable int id){
       return contactDAO.search(id);
    }*/

}
