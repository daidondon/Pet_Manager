package com.example.pet_manager.service.Impl;

import com.example.pet_manager.dto.ChatMessageDTO;
import com.example.pet_manager.entity.Message;
import com.example.pet_manager.repository.ChatMessageRepository;
import com.example.pet_manager.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public List<ChatMessageDTO> getChatMessages(Long senderId1, Long receiverId1, Long senderId2, Long receiverId2) {
        return chatMessageRepository.findChatMessages(senderId1, receiverId1, senderId2, receiverId2);
    }

    public Message saveMessage(Message chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }
}
