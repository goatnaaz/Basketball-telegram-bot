package com.example.Basketballtelegrambot.commandTest;

import com.example.Basketballtelegrambot.command.Command;
import com.example.Basketballtelegrambot.command.PastCommand;

import static com.example.Basketballtelegrambot.command.CommandName.PAST;
import static com.example.Basketballtelegrambot.command.PastCommand.PAST_EVENT_MESSAGE;

public class PastCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return PAST.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return PAST_EVENT_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new PastCommand(sendBotMessageService);
    }
}
