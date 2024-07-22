package com.example.pet_manager.repository;

import com.example.pet_manager.dto.ChatMessageDTO;
import com.example.pet_manager.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<Message, Long> {
    @Query(value = "SELECT m.id, m.sender_id, sender.gmail AS sender_name, " +
            "       m.receiver_id, receiver.gmail AS receiver_name, " +
            "       m.content, m.timestamp, m.message_type " +
            "FROM message m " +
            "JOIN [user] sender ON m.sender_id = sender.id " +
            "JOIN [user] receiver ON m.receiver_id = receiver.id " +
            "WHERE (m.sender_id = ?1 AND m.receiver_id = ?2) " +
            "   OR (m.sender_id = ?3 AND m.receiver_id = ?4) " +
            "ORDER BY m.timestamp ASC", nativeQuery = true)
    List<ChatMessageDTO> findChatMessages(Long senderId1, Long receiverId1, Long senderId2, Long receiverId2);
}
