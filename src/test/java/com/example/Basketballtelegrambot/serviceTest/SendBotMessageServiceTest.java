package com.example.Basketballtelegrambot.serviceTest;

import com.example.Basketballtelegrambot.bot.BasketballTelegramBot;
import com.example.Basketballtelegrambot.service.SendBotMessageService;
import com.example.Basketballtelegrambot.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private BasketballTelegramBot basketballTelegramBot;

    @BeforeEach
    public void init() {
        basketballTelegramBot = Mockito.mock(BasketballTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(basketballTelegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        //when
        sendBotMessageService.sendMessage(chatId, message);

        //then
        Mockito.verify(basketballTelegramBot).execute(sendMessage);
    }
}
