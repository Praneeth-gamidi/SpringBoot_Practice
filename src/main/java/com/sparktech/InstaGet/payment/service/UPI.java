package com.sparktech.InstaGet.payment.service;

public class UPI implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Payment done using UPI");
    }
}
