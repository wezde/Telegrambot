package com.github.wezde.wezdetelegrambot.command;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    NO("no command"),
    HELP("/help");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
