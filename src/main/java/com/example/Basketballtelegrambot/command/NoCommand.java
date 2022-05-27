package com.example.Basketballtelegrambot.command;

import com.example.Basketballtelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * No {@link Command}.
 */
public class NoCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public static final String NO_MESSAGE = "I understand commands which starts with : (/).\n"
            + "If you want to see list of commands write : /help";

    public NoCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);

    }
}
