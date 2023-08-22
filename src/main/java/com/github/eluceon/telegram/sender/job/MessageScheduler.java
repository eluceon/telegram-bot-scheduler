package com.github.eluceon.telegram.sender.job;

import com.github.eluceon.telegram.sender.entity.Message;
import com.github.eluceon.telegram.sender.mapper.MessageMapper;
import com.github.eluceon.telegram.sender.repository.MessageRepository;
import com.github.eluceon.telegram.sender.service.TelegramClient;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MessageScheduler {
    private final MessageRepository messageRepository;
    private final ThreadPoolTaskScheduler taskScheduler;
    private final TelegramClient client;
    private final MessageMapper mapper;

    @Scheduled(cron = "${scheduler.cron-expression}", zone = "Europe/Moscow")
    public void sendScheduledMessages() {
        LocalTime currentTime = LocalTime.now();
        List<Message> messages = messageRepository.findAll();

        messages.stream()
                .filter(message -> currentTime.getHour() == message.getScheduledTime().getHour() &&
                        currentTime.getMinute() == message.getScheduledTime().getMinute())
                .forEach(message -> taskScheduler.execute(() -> client.sendMessage(mapper.toDto(message))));
    }
}
