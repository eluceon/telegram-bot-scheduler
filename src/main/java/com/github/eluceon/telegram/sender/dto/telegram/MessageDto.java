package com.github.eluceon.telegram.sender.dto.telegram;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDto {
    @JsonProperty("chat_id")
    @NotNull
    private String chatId;

    @JsonProperty("text")
    @NotNull
    private String text;

    @JsonProperty("parse_mode")
    private String parseMode;

    @JsonProperty("disable_web_page_preview")
    private Boolean disableWebPagePreview;

    @JsonProperty("disable_notification")
    private Boolean disableNotification;

    @JsonProperty("reply_to_message_id")
    private String replyToMessageId;
}
