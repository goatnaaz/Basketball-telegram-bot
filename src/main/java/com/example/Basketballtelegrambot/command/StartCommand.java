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


    public final static String START_MESSAGE = "Hi . I am basketball telegram bot I can show you" +
            "future and past matches with odd on them";

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
                        telegramUser.setChatId(chatId);
                        telegramUserService.save(telegramUser);
                    });

            sendBotMessageService.sendMessage(chatId, START_MESSAGE);
        }


    }

