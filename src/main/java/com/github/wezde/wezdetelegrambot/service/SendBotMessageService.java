package com.github.wezde.wezdetelegrambot.service;

public interface SendBotMessageService {

    void sendMessage(String chatID, String message);
}
