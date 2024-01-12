package com.ltizzi.EasyBankBackend.controller;

import com.ltizzi.EasyBankBackend.model.Loans;
import com.ltizzi.EasyBankBackend.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoanRepository loanRepo;


    @GetMapping("/myLoans")
    @PostAuthorize("hasRole('USER')")
    public List<Loans> getLoanDetails(@RequestParam Long id){
        List<Loans> loans = loanRepo.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null){
            return loans;
        } else {
            return null;
        }
        //return "Here are the loan details from the DB";
    }
}
