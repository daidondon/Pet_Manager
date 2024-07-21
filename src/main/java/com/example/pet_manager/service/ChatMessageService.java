package com.example.pet_manager.service;

import com.example.pet_manager.dto.ChatMessageDTO;
import com.example.pet_manager.entity.Message;

import java.util.List;

public interface ChatMessageService {
    public List<ChatMessageDTO> getChatMessages(Long senderId1, Long receiverId1, Long senderId2, Long receiverId2);
    public Message saveMessage(Message chatMessage);
}
