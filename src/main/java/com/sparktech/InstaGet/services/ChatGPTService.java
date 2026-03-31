package com.sparktech.InstaGet.services;

import org.springframework.stereotype.Service;

@Service("chatGPTService")
public class ChatGPTService implements AiService{
    public void generate(){
        System.out.println("This is chatgpt response");
    }
}

