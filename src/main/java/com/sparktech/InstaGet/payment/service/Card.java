package com.sparktech.InstaGet.payment.service;

import org.springframework.beans.factory.annotation.Value;

public class Card implements PaymentService {

    @Value("${card.name:HDFC Card}")
    private String cardName;

    @Override
    public void pay() {
        System.out.println("Payment done using Card: " + cardName);
    }
}
