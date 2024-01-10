package com.ltizzi.EasyBankBackend.controller;

import com.ltizzi.EasyBankBackend.model.Accounts;
import com.ltizzi.EasyBankBackend.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepo;
    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam Long id){
        Accounts accounts = accountsRepo.findByCustomerId(id);
        if (accounts!=null){
            return accounts;
        }else {
            return null;
        }
        //return "Here are the account details from the DB"; //devolvía un string en principio
    }
}
