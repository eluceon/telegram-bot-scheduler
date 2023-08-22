package com.github.eluceon.telegram.sender.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalTime;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "MESSAGES")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TEXT")
    @NotNull
    private String text;

    @Column(name = "CHAT_ID")
    @NotNull
    private String chatId;

    @Column(name = "SCHEDULED_TIME")
    @NotNull
    private LocalTime scheduledTime;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private ZonedDateTime createdAt;
}
