package com.example.Basketballtelegrambot.command;

import com.example.Basketballtelegrambot.service.SendBotMessageService;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.telegram.telegrambots.meta.api.objects.Update;



/**
 * Start {@link Command}.
 */
public class StartCommand implements  Command{

    

    private final SendBotMessageService sendBotMessageService;

    public final static String START_MESSAGE = "Hi!" + " I am Basketball telegram bot . I can help you to get last  " +
            "news from the best Basketball league in the world : NBA";


    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {

        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);


    }
}
