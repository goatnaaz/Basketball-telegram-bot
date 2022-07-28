package com.example.Basketballtelegrambot.command;

import com.example.Basketballtelegrambot.repository.entity.Feedback;
import com.example.Basketballtelegrambot.service.FeedbackService;
import com.example.Basketballtelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.example.Basketballtelegrambot.command.CommandUtils.getMessage;

/**
 * Message  {@link Command}.
 */
public class MessageCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final FeedbackService feedbackService;

    public static final String MESSAGE = "Thanks for your feedback , it makes our bot better";


    public MessageCommand(SendBotMessageService sendBotMessageService, FeedbackService feedbackService) {
        this.sendBotMessageService = sendBotMessageService;
        this.feedbackService = feedbackService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        sendBotMessageService.sendMessage(chatId, MESSAGE);

        String message =  getMessage(update);

            feedbackService.findByChatId(chatId).ifPresentOrElse(
                    user -> {

                        feedbackService.save(user);

                    },
                    () -> {

                        Feedback feedback = new Feedback();
                            feedback.setChatId(chatId);

                            feedback.saveMessage(message);

                            feedbackService.save(feedback);


                    });
    }
}
