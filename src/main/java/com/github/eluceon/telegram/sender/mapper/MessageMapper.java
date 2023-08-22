package com.github.eluceon.telegram.sender.mapper;


import com.github.eluceon.telegram.sender.dto.MessageDto;
import com.github.eluceon.telegram.sender.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageDto toDto(Message entity);
}
