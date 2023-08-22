package com.github.eluceon.telegram.sender.service;

import com.github.eluceon.telegram.sender.dto.ScheduledMessageDto;
import com.github.eluceon.telegram.sender.entity.Message;
import com.github.eluceon.telegram.sender.mapper.MessageMapper;
import com.github.eluceon.telegram.sender.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper mapper;

    @Transactional
    public void add(@RequestBody ScheduledMessageDto scheduledMessage) {
        Message entity = mapper.toEntity(scheduledMessage);
        messageRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Transactional
    public void deleteById(@PathVariable Long id) {
        messageRepository.deleteById(id);
    }

}
