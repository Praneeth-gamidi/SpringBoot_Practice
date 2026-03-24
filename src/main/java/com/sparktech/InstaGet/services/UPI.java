package com.sparktech.InstaGet.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("upi")
@Primary
public class UPI implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Payment done using UPI");
    }
}