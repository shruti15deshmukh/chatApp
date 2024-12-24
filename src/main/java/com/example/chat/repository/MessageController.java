package com.example.chat.repository;

import com.example.chat.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageController extends MongoRepository<Message, String> {
    List<Message> findByGroupId(String groupId);
    List<Message> findBySenderIdAndReceiverId(String senderId, String receiverId);

}
