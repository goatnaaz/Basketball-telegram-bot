package com.example.Basketballtelegrambot.repository.entity;

import com.example.Basketballtelegrambot.command.FeedbackCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * {@link Repository} for handling with {@link Feedback} entity.
 */

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback , String> {

}
