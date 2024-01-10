package com.ltizzi.EasyBankBackend.repository;

import com.ltizzi.EasyBankBackend.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

}
