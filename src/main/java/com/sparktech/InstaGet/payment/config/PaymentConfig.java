package com.sparktech.InstaGet.payment.config;

import com.sparktech.InstaGet.payment.service.Card;
import com.sparktech.InstaGet.payment.service.NetBanking;
import com.sparktech.InstaGet.payment.service.PaymentService;
import com.sparktech.InstaGet.payment.service.UPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PaymentConfig {

    @Bean
    @Primary
    public PaymentService upi() {
        return new UPI();
    }

    @Bean
    public PaymentService card() {
        return new Card();
    }

    @Bean
    public PaymentService netBanking() {
        return new NetBanking();
    }
}
