package com.example.Basketballtelegrambot.commandTest;

import com.example.Basketballtelegrambot.command.AdminHelpCommand;
import com.example.Basketballtelegrambot.command.Command;
import org.junit.jupiter.api.DisplayName;

import static com.example.Basketballtelegrambot.command.AdminHelpCommand.ADMIN_HELP_MESSAGE;
import static com.example.Basketballtelegrambot.command.CommandName.ADMIN_HELP;

@DisplayName("Unit-level testing for AdminHelpCommand")
public class AdminHelpCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return ADMIN_HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return ADMIN_HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new AdminHelpCommand(sendBotMessageService);
    }
}
