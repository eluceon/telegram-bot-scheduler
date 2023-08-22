package com.github.eluceon.telegram.sender.mapper;


import com.github.eluceon.telegram.sender.dto.ScheduledMessageDto;
import com.github.eluceon.telegram.sender.dto.telegram.MessageDto;
import com.github.eluceon.telegram.sender.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageDto toMessageDto(Message entity);
    Message toEntity(ScheduledMessageDto scheduledMessageDto);
}
