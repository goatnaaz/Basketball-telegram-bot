package com.example.Basketballtelegrambot.command;

import com.example.Basketballtelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Future Events {@link Command}.
 */
public class FutureCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public static final String FUTURE_EVENT_MESSAGE = "There is no future events now ";

    public FutureCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString() , FUTURE_EVENT_MESSAGE);
    }
}
