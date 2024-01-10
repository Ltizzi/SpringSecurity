package com.ltizzi.EasyBankBackend.controller;

import com.ltizzi.EasyBankBackend.model.Cards;
import com.ltizzi.EasyBankBackend.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepo;
    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam Long id){
        List<Cards> cards = cardsRepo.findByCustomerId(id);
        if(cards != null){
            return cards;
        } else {
            return null;
        }
        //return "Here are the card details from the DB";
    }
}
