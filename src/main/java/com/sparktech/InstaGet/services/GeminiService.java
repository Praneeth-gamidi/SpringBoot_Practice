package com.sparktech.InstaGet.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("geminiService")
@Primary
public class GeminiService implements AiService {
    public void generate() {
        System.out.println("This is Gemini response");
    }
}
