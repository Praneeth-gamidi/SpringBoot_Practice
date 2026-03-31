package com.sparktech.InstaGet;

import com.sparktech.InstaGet.services.Card;
import com.sparktech.InstaGet.services.NetBanking;
import com.sparktech.InstaGet.services.PaymentService;
import com.sparktech.InstaGet.services.UPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

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
