package com.ltizzi.EasyBankBackend.repository;

import com.ltizzi.EasyBankBackend.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {

    Accounts findByCustomerId(Long customerId);
}
