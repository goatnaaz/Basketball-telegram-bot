package com.example.Basketballtelegrambot.commandTest;

import com.example.Basketballtelegrambot.command.Command;
import com.example.Basketballtelegrambot.command.NoCommand;
import org.junit.jupiter.api.DisplayName;

import static com.example.Basketballtelegrambot.command.CommandName.NO;
import static com.example.Basketballtelegrambot.command.NoCommand.NO_MESSAGE;

@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends  AbstractCommandTest{
    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}
