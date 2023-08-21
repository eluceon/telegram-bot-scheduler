package com.github.eluceon.telegram.sender.repository;

import com.github.eluceon.telegram.sender.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
