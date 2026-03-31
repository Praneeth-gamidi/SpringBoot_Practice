package com.sparktech.InstaGet.payment.service;

public class NetBanking implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Payment done using NetBanking");
    }
}
