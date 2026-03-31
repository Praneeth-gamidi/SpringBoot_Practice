package com.sparktech.InstaGet.services;

public class NetBanking implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Payment done using NetBanking");
    }
}
