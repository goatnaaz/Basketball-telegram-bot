package com.example.Basketballtelegrambot.service;



import com.example.Basketballtelegrambot.command.FeedbackCommand;
import com.example.Basketballtelegrambot.repository.entity.Feedback;
import com.example.Basketballtelegrambot.repository.entity.TelegramUser;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * {@link Service} for handling {@link Feedback} entity.
 */

public interface FeedbackService {
    /**
     * Save provided {@link Feedback} entity.
     *
     *
     */
    void save(Feedback feedback);



    Optional<Feedback> findByChatId(String chatId);
}
