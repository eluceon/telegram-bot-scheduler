package com.github.eluceon.telegram.sender.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalTime;
@Data
public class ScheduledMessageDto {

    @NotNull
    private String text;

    @NotNull
    private String chatId;

    @NotNull
    private LocalTime scheduledTime;
}
