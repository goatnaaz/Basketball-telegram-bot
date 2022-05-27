package com.example.Basketballtelegrambot.commandTest;

import com.example.Basketballtelegrambot.command.Command;
import com.example.Basketballtelegrambot.command.StopCommand;
import org.junit.jupiter.api.DisplayName;

import static com.example.Basketballtelegrambot.command.CommandName.STOP;
import static com.example.Basketballtelegrambot.command.StopCommand.STOP_MESSAGE;

@DisplayName("Unit-level testing for StopCommand")
public class StopCommandTest extends  AbstractCommandTest{
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}
