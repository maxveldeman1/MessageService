package be.vdab.messageService.services;

import be.vdab.messageService.Message;
import be.vdab.messageService.repositories.MessageRepository;

public class MessageWriter {
    private MessageRepository messageRepository;

    public MessageWriter() {
        messageRepository = new MessageRepository();
    }

    public void write(Message message) {
        messageRepository.write(message);
    }
}
