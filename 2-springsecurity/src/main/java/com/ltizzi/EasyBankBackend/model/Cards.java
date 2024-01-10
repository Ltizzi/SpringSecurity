package com.ltizzi.EasyBankBackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;


@Entity
@Getter
@Setter
@Table(name="cards")
public class Cards {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator = "native")
    @GenericGenerator(name="native", strategy = "native")
    @Column(name="card_id")
    private Long cardId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name="card_number")
    private String cardNumber;

    @Column(name="card_type")
    private String cardType;

    @Column(name="total_limit")
    private int totalLimit;

    @Column(name="amount_used")
    private int amountUsed;

    @Column(name="avaible_amount")
    private int avaibleAmount;

    @Column(name="create_dt")
    private Date createDt;
}
