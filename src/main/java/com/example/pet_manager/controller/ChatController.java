package com.example.pet_manager.controller;

import com.example.pet_manager.dto.ChatMessageDTO;
import com.example.pet_manager.entity.Message;
import com.example.pet_manager.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ChatController {

    @Autowired
    private ChatMessageService chatMessageService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessageDTO sendMessage(Message chatMessage) {
        String senderName = "Phong HD"; // Lấy tên của người gửi từ Principal
        chatMessage.setSenderId(9L);

        // Lưu tin nhắn vào cơ sở dữ liệu
        Message savedMessage = chatMessageService.saveMessage(chatMessage);

        // Chuyển đổi và trả về DTO
        return new ChatMessageDTO(savedMessage.getId(), savedMessage.getSenderId(), senderName,
                savedMessage.getReceiverId(), "Lam", savedMessage.getContent(),
                savedMessage.getTimestamp(), savedMessage.getMessageType());
    }

    @MessageMapping("/chat.getMessages")
    @SendTo("/topic/public")
    public List<ChatMessageDTO> getMessages(Message chatMessage) {
        Long currentUserId = Long.parseLong("9"); // Lấy id của người dùng hiện tại
        Long receiverId = chatMessage.getReceiverId();
        List<ChatMessageDTO> messages = chatMessageService.getChatMessages(currentUserId, receiverId, receiverId, currentUserId)
                .stream()
                .map(message -> new ChatMessageDTO(message.getId(), message.getSenderId(),
                        message.getSenderName(), message.getReceiverId(), message.getReceiverName(),
                        message.getContent(), message.getTimestamp(), message.getMessageType()))
                .collect(Collectors.toList());
        return messages;
    }
}
