package com.sparktech.InstaGet.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("card")
public class Card implements PaymentService {

    @Value("${card.name:HDFC Card}")
    private String cardName;

    @Override
    public void pay() {
        System.out.println("Payment done using Card: " + cardName);
    }
}