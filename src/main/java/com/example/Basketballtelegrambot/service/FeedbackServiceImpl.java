package com.example.Basketballtelegrambot.service;

import com.example.Basketballtelegrambot.command.FeedbackCommand;
import com.example.Basketballtelegrambot.repository.entity.Feedback;
import com.example.Basketballtelegrambot.repository.entity.FeedbackRepository;
import com.example.Basketballtelegrambot.repository.entity.TelegramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
@Component
public class FeedbackServiceImpl implements FeedbackService {

    private  final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }


    @Override
    public void save(Feedback feedback) {
        feedbackRepository.save(feedback);
    }




    @Override
    public Optional<Feedback> findByChatId(String chatId) {
        return feedbackRepository.findById(chatId);
    }
}
