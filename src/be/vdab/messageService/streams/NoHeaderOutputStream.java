package be.vdab.messageService.streams;

import be.vdab.messageService.repositories.FilePath;

import java.io.*;

public class NoHeaderOutputStream extends ObjectOutputStream {
    private static FileInputStream fileInputStream;

    static {
        try {
            fileInputStream = new FileInputStream(FilePath.STANDARD_PATH.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public NoHeaderOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        if (fileInputStream.read() == -1) {
            super.writeStreamHeader();
        }
    }


}
