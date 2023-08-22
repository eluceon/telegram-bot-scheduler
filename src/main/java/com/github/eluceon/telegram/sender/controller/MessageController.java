package com.github.eluceon.telegram.sender.controller;

import com.github.eluceon.telegram.sender.dto.ScheduledMessageDto;
import com.github.eluceon.telegram.sender.entity.Message;
import com.github.eluceon.telegram.sender.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/")
    public void add(@RequestBody ScheduledMessageDto scheduledMessage) {
        messageService.add(scheduledMessage);
    }

    @GetMapping("/")
    public List<Message> getAll() {
        return messageService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        messageService.deleteById(id);
    }
}
