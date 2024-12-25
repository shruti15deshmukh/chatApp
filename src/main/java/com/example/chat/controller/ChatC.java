package com.example.chat.controller;

import com.example.chat.model.Group;
import com.example.chat.model.Message;
import com.example.chat.service.GroupS;
import com.example.chat.service.MessageS;
import com.example.chat.service.UserS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatC {
    @Autowired
    private UserS userS;

    @Autowired
    private MessageS messageS;

    @Autowired
    private GroupS groupS;
    @GetMapping("/history/{userId}")
    public List<Message> getChatHistory(@PathVariable String userId, @RequestParam(required = false) String groupId) {
        return messageS.getMessages(userId, groupId);
    }
    @PostMapping("/updateStatus")
    public void updateUserStatus(@RequestParam String userId, @RequestParam boolean isOnline) {
        userS.updateUserStatus(userId, isOnline);
    }
    @PostMapping("/createGroup")
    public Group createGroup(@RequestBody Group group) {
        return groupS.createGroup(group);
    }
    @PostMapping("/sendMessage")
    public Message sendMessage(@RequestBody Message message) {
        return messageS.saveMessage(message);
    }

}
