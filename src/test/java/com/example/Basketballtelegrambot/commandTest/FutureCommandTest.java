package com.example.Basketballtelegrambot.commandTest;

import com.example.Basketballtelegrambot.command.Command;
import com.example.Basketballtelegrambot.command.FutureCommand;
import org.junit.jupiter.api.DisplayName;

import static com.example.Basketballtelegrambot.command.CommandName.FUTURE;
import static com.example.Basketballtelegrambot.command.FutureCommand.FUTURE_EVENT_MESSAGE;

@DisplayName("Unit-level testing for FutureCommand")
public class FutureCommandTest extends  AbstractCommandTest{
    @Override
    String getCommandName() {
        return FUTURE.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return FUTURE_EVENT_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new FutureCommand(sendBotMessageService);
    }
}
