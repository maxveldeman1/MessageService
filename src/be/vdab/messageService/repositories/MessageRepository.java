package be.vdab.messageService.repositories;

import be.vdab.messageService.Message;
import be.vdab.messageService.streams.NoHeaderOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MessageRepository {
    String path = FilePath.STANDARD_PATH.toString();

    public void write(Message message) {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(path);
//                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                NoHeaderOutputStream noHeaderOutputStream = new NoHeaderOutputStream(fileOutputStream);
        )  {

            noHeaderOutputStream.writeObject(message);
//            noHeaderOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Message read() {
        try (
                FileInputStream fileInputStream = new FileInputStream(path);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            return (Message) objectInputStream.readObject();
        } catch (EOFException eof) {

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Message>  readAll() {
        List<Message> messages = new ArrayList<>();

        try (
                FileInputStream fileInputStream = new FileInputStream(path);
//                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            Object message;
            while ((message = objectInputStream.readObject()) != null) {
                messages.add((Message) message);
            }
        } catch (EOFException eof) {

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return messages;
    }
}
