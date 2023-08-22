package com.github.eluceon.telegram.sender.service;

import com.github.eluceon.telegram.sender.dto.MessageDto;
import com.github.eluceon.telegram.sender.dto.ResponseDto;
import com.github.eluceon.telegram.sender.exception.TelegramException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramClient {
    private final WebClient telegramWebClient;

     public ResponseDto sendMessage(MessageDto request) {
         log.info(request.toString());
         var response = telegramWebClient.post()
                 .uri("/sendMessage")
                 .body(BodyInserters.fromValue(request))
                 .retrieve()
                 .bodyToMono(ResponseDto.class)
                 .block();

         if (Objects.nonNull(response)) {
             log.info("Получен ответ от telegram {}", response);
             if (Boolean.FALSE.equals(response.getOk())) {
                 throw new TelegramException("Ошибка при отправке сообщения через telegram");
             }
             return response;
         }

         log.error("Не удалось получить ответ от telegram");
         throw new TelegramException("Не удалось получить ответ от telegram");
     }
}
