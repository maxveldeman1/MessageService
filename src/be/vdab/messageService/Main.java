package be.vdab.messageService;

import be.vdab.messageService.services.MessageService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MessageService messageService = new MessageService();
        Scanner keyboard = new Scanner(System.in);

        Thread readThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                messageService.printAllUniqueMessages();
            }
        });

        Thread writeThread = new Thread(() -> {
            while (true) {
                messageService.write(new Message(keyboard.nextLine()));
            }
        });

        readThread.start();
        writeThread.start();

//        MessageWriter writer = new MessageWriter();
//        writer.write(new Message("How are you doing?"));
    }
}
