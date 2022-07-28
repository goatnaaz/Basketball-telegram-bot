package com.example.Basketballtelegrambot.service;

import com.example.Basketballtelegrambot.parser.Event;
import org.jsoup.select.Elements;

/**
 * Service for sending messages via telegram-bot.
 */
public interface SendBotMessageService {
    /**
     * Send message via telegram bot.
     *
     * @param chatId provided chatId in which messages would be sent.
     * @param message provided message to be sent.
     */
    void sendMessage(String chatId, String message);

    void sendMessage(String chatId , Elements elements );

    void sendMessage(String chatId , Event event );
}
