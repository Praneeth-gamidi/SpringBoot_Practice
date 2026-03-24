package com.sparktech.InstaGet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ResponseGenerator {

    @Value("${ai.service.name:Gemini}")
    private String serviceName;

    private AiService aiModel;

    @Autowired
    public ResponseGenerator(@Qualifier("geminiService") AiService aiModel) {
        this.aiModel = aiModel;
    }

    public void work() {
        System.out.println("Using AI service: " + serviceName);
        aiModel.generate();
    }

    public void work(AiService aiModel) {
        System.out.println("Using AI service: " + aiModel.getClass().getSimpleName());
        aiModel.generate();
    }
}
