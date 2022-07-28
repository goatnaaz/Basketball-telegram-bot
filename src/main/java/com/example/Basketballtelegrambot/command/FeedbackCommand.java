package com.example.Basketballtelegrambot.command;

import com.example.Basketballtelegrambot.repository.entity.Feedback;
import com.example.Basketballtelegrambot.service.FeedbackService;
import com.example.Basketballtelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Scanner;

import static com.example.Basketballtelegrambot.command.CommandName.MESSAGE;
import static com.example.Basketballtelegrambot.command.CommandUtils.getMessage;

/**
 * Feedback {@link Command}.
 */

public class FeedbackCommand implements  Command {

    private final SendBotMessageService sendBotMessageService;

    private final FeedbackService feedbackService;


    public final static String FEEDBACK_MESSAGE = "Hello user! If you have thoughts about our bot you can wright it down and we will read it.For it you need to wright '/message' and after that your thoughts. You can do it only once";

    public FeedbackCommand(SendBotMessageService sendBotMessageService, FeedbackService feedbackService) {
        this.sendBotMessageService = sendBotMessageService;
        this.feedbackService = feedbackService;
    }

    Scanner scanner = new Scanner(System.in);


    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();



        sendBotMessageService.sendMessage(chatId, FEEDBACK_MESSAGE);



        if (getMessage(update).equalsIgnoreCase(MESSAGE.getCommandName())) {
            MessageCommand messageCommand = new MessageCommand(sendBotMessageService, feedbackService);
            messageCommand.execute(update);

        }







    }
}

