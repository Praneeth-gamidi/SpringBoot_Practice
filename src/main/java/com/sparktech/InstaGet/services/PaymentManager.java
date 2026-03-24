package com.sparktech.InstaGet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentManager {

    @Autowired
    private PaymentService paymentService;

    public void processPayment() {
        paymentService.pay();
    }
}