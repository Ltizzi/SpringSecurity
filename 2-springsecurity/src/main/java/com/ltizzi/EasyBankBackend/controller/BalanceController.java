package com.ltizzi.EasyBankBackend.controller;

import com.ltizzi.EasyBankBackend.model.AccountTransactions;
import com.ltizzi.EasyBankBackend.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository accountTransactionRepo;
    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalance(@RequestParam Long id){
        List<AccountTransactions> accountTransactions = accountTransactionRepo.findByCustomerIdOrderByTransactionDtDesc(id);
        if(accountTransactions!= null){
            return accountTransactions;
        } else {
            return null;
        }
        //return "Here are the balance details from the DB";
    }
}
