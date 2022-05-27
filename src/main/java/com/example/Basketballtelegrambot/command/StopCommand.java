package com.example.Basketballtelegrambot.command;

import com.example.Basketballtelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;
/**
 * Stop {@link Command}.
 */

public class StopCommand implements  Command{

    private final SendBotMessageService sendBotMessageService;

    public static final String STOP_MESSAGE = "Deactivated everything \uD83D\uDE1F.";


    public StopCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
