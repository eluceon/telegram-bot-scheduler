package com.github.eluceon.telegram.sender.exception;

/*
** Исключение выбрасываемое при получении ошибки от telegram
 */
public class TelegramException extends RuntimeException {
    public TelegramException(String message) {
        super(message);
    }
}
