package com.example.Basketballtelegrambot.command;


import com.example.Basketballtelegrambot.service.FeedbackService;
import com.example.Basketballtelegrambot.service.SendBotMessageService;

import com.example.Basketballtelegrambot.service.TelegramUserService;
import com.google.common.collect.ImmutableMap;

import static com.example.Basketballtelegrambot.command.CommandName.*;

/**
 * Container of the {@link Command}s, which are using for handling telegram commands.
 */
public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService , FeedbackService feedbackService) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService , telegramUserService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService , telegramUserService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .put(PAST.getCommandName(), new PastCommand(sendBotMessageService))
                .put(FUTURE.getCommandName(), new FutureCommand(sendBotMessageService))
                .put(STAT.getCommandName(), new StatCommand(sendBotMessageService, telegramUserService))
                .put(FEEDBACK.getCommandName(), new FeedbackCommand(sendBotMessageService , feedbackService))
                .put(MESSAGE.getCommandName(), new MessageCommand(sendBotMessageService, feedbackService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }


}
