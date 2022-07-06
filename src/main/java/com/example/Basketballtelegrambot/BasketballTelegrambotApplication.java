package com.example.Basketballtelegrambot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.starter.AfterBotRegistration;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class BasketballTelegrambotApplication {
	public static void main(String[] args) {
		SpringApplication.run(BasketballTelegrambotApplication.class, args);

	}

	@AfterBotRegistration
	public void afterRegistration(BotSession session) { session.stop(); }


}
