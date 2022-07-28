package com.example.Basketballtelegrambot.command;

import com.example.Basketballtelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Past Events {@link Command}.
 */
public class PastCommand implements  Command{

    private final SendBotMessageService sendBotMessageService;

    public final static String  PAST_EVENT_MESSAGE = "Here is results of matches ";


    public PastCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString() , PAST_EVENT_MESSAGE);


    }
}
