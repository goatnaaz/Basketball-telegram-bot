package com.example.Basketballtelegrambot.command;

/**
 * Enumeration for {@link Command}'s.
 */
public enum CommandName {

    START("/start"),
    STOP("/stop"),

    FUTURE("/future_events"),

    PAST("/past_events"),

    NO("/no"),

    STAT("/stat"),

    FEEDBACK("/feedback"),

    HELP("/help"),

    ADMIN_HELP("/ahelp"),

    MESSAGE("/message");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
