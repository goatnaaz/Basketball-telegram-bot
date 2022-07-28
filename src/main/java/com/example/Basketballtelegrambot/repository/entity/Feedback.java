package com.example.Basketballtelegrambot.repository.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "feedback")
@EqualsAndHashCode(exclude = "message")
public class Feedback {
    @Id
    @Column(name = "user_id")
    private String userId;


    @Column(name = "message")
    private String message;


    public void saveMessage(String message) {
        this.message = message;
    }

    public void deleteMessage(){
        saveMessage("No message");
    }

    public void setChatId(String userId) {
        this.userId = userId;
    }
}
