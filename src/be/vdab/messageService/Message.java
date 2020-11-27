package be.vdab.messageService;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Message implements Serializable {
    transient public static long count = 0;
    public static final long serialVersionUID = 1;

    private String name = "Sven";
    private LocalDate date = LocalDate.now();
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        addTabsIfEven(stringBuilder);
        stringBuilder.append(date).append("\n");
        addTabsIfEven(stringBuilder);
        stringBuilder.append(name).append("\n");
        addTabsIfEven(stringBuilder);
        stringBuilder.append(message);
        return stringBuilder.toString();
    }

    private void addTabsIfEven(StringBuilder stringBuilder) {
        if (count % 2 == 0) {
            stringBuilder.append("\t\t\t");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message1 = (Message) o;
        return Objects.equals(getName(), message1.getName()) &&
                Objects.equals(getDate(), message1.getDate()) &&
                Objects.equals(getMessage(), message1.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDate(), getMessage());
    }
}
