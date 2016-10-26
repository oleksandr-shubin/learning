package utills;

import java.io.IOException;
import java.io.InputStream;

public class UnclosableInputStream extends InputStream {

    private final InputStream inputstream;

    public UnclosableInputStream(InputStream inputstream) {
        this.inputstream = inputstream;
    }

    @Override
    public int read() throws IOException {
        try {
            return inputstream.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void close() throws IOException {

    }
}
