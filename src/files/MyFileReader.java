package files;

import Exceptions.ClosedFileException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
    private BufferedReader br = null;
    private final String filename;
    private String value;

    public MyFileReader(String filename) throws FileNotFoundException {
        this.br = new BufferedReader(new FileReader(filename));
        this.filename = filename;
        this.value = null;
    }

    private BufferedReader getBr() { return br; }

    public String Read() throws ClosedFileException, IOException {
        if (this.getBr() == null) { throw new ClosedFileException("file isn't opened"); }
        this.value = this.br.readLine();
        return this.value;
    }
    public void Close() throws IOException { this.br.close(); }
    public String GetFilename() { return filename; }

    public String getValue() { return value; }
}
