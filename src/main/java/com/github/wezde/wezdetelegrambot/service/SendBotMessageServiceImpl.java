package com.github.wezde.wezdetelegrambot.service;

import com.github.wezde.wezdetelegrambot.bot.WezdeTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService{

    private final WezdeTelegramBot wezdeTelegramBot;

    @Autowired
    public SendBotMessageServiceImpl(WezdeTelegramBot wezdeTelegramBot) {
        this.wezdeTelegramBot = wezdeTelegramBot;
    }

    @Override
    public void sendMessage(String chatID, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            wezdeTelegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
