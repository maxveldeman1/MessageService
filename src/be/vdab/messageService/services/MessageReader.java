package be.vdab.messageService.services;

import be.vdab.messageService.Message;
import be.vdab.messageService.repositories.MessageRepository;

import java.util.ArrayList;
import java.util.List;

public class MessageReader {
    private MessageRepository messageRepository;

    public MessageReader() {
        messageRepository = new MessageRepository();
    }

    public Message getMessage() {
        return messageRepository.read();
    }

    public List<Message> getAllMessages() {
        return messageRepository.readAll();
    }

}
