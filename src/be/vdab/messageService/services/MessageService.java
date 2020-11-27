package be.vdab.messageService.services;

import be.vdab.messageService.Message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MessageService {
    private final MessageReader messageReader;
    private final MessageWriter messageWriter;
    private List<Message> knownMessages;

    public MessageService() {
        messageReader = new MessageReader();
        messageWriter = new MessageWriter();
        knownMessages = new ArrayList<>();
    }

    public void printAllMessages() {
        messageReader.getAllMessages().forEach(System.out::println);
    }

    public void printAllUniqueMessages() {
        List<Message> messages = messageReader.getAllMessages();
        messages.removeAll(knownMessages);
        messages.forEach(System.out::println);

        knownMessages.addAll(messages);
    }

    public void write(Message message) {
        messageWriter.write(message);
    }

    public void write(Message... messages) {
        for (Message mess: messages) {
            write(mess);
        }
    }

    public void write(Collection<Message> messages) {
        messages.forEach(messageWriter::write);
    }


}
