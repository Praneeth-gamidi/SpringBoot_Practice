package com.sparktech.InstaGet.services;

import org.springframework.stereotype.Service;

@Service("netBanking")
public class NetBanking implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Payment done using NetBanking");
    }
}