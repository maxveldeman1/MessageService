package be.vdab.messageService.repositories;

public enum FilePath {
    STANDARD_PATH("C:\\Users\\Student\\Documents\\MessagesJavaWondelgemNj20\\messages.txt"),
    NETWORK_PATH("\\\\DESKTOP-FEFG3RG\\Users\\Student\\Documents\\MessagesJavaWondelgemNj20\\messages.txt");

    private final String path;

    FilePath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
