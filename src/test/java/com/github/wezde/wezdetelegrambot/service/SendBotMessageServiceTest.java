package com.github.wezde.wezdetelegrambot.service;

import com.github.wezde.wezdetelegrambot.bot.WezdeTelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private WezdeTelegramBot wezdeTelegramBot;

    @BeforeEach
    public void init() {
        wezdeTelegramBot = Mockito.mock(WezdeTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(wezdeTelegramBot);
    }
    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        String chatID = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatID);
        sendMessage.enableHtml(true);

        //when
        sendBotMessageService.sendMessage(chatID, message);

        //then
        Mockito.verify(wezdeTelegramBot).execute(sendMessage);
    }
}
