package com.example.Basketballtelegrambot.command;

import com.example.Basketballtelegrambot.repository.entity.TelegramUser;
import com.example.Basketballtelegrambot.service.SendBotMessageService;



import com.example.Basketballtelegrambot.service.TelegramUserService;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.telegram.telegrambots.meta.api.objects.Update;



/**
 * Start {@link Command}.
 */
public class StartCommand implements  Command{

    

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String START_MESSAGE = "Hi!" + " I am Basketball telegram bot . I can help you to get last  " +
            "news from the best Basketball league in the world : NBA";

    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }




    @Override
    public void execute(Update update) {

        String chatId = update.getMessage().getChatId().toString();

        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(true);
                    telegramUserService.save(user);
                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setActive(true);
                    telegramUser.setChat_id(chatId);
                    telegramUserService.save(telegramUser);
                });

        sendBotMessageService.sendMessage(chatId, START_MESSAGE);



    }
}
