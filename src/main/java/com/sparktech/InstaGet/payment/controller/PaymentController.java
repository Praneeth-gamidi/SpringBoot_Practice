package com.sparktech.InstaGet.payment.controller;

import com.sparktech.InstaGet.payment.service.PaymentManager;
import com.sparktech.InstaGet.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentManager paymentManager;

    @Autowired
    @Qualifier("upi")
    private PaymentService upiService;

    @Autowired
    @Qualifier("card")
    private PaymentService cardService;

    @Autowired
    @Qualifier("netBanking")
    private PaymentService netBankingService;

    @GetMapping("/upi")
    public String payWithUpi() {
        upiService.pay();
        return "Payment done using UPI";
    }

    @GetMapping("/card")
    public String payWithCard() {
        cardService.pay();
        return "Payment done using Card";
    }

    @GetMapping("/netbanking")
    public String payWithNetBanking() {
        netBankingService.pay();
        return "Payment done using NetBanking";
    }

    @GetMapping("/default")
    public String payDefault() {
        paymentManager.processPayment();
        return "Payment processed using default method (UPI)";
    }
}
