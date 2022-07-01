package com.example.Basketballtelegrambot.command;

import com.example.Basketballtelegrambot.service.SendBotMessageService;
import com.example.Basketballtelegrambot.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;



public class StatCommand implements Command{

    private final TelegramUserService telegramUserService;
    private final SendBotMessageService sendBotMessageService;

    @Autowired
    public StatCommand(TelegramUserService telegramUserService , SendBotMessageService sendBotMessageService){
        this.telegramUserService = telegramUserService;
        this.sendBotMessageService = sendBotMessageService;
    }

    public final static String STAT_MESSAGE = "Javarush Telegram Bot использует %s человек.";

    @Override
    public void execute(Update update) {
        int activeUserCount = telegramUserService.retriveAllActiveUsers().size();
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),String.format(STAT_MESSAGE, activeUserCount));

    }
}
