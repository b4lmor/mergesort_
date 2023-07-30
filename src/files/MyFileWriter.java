package files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
    private final FileWriter fileWriter;
    private final String filename;

    public MyFileWriter(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) { file.createNewFile(); }
        this.fileWriter = new FileWriter(file);
        this.filename = filename;
    }

    public void Write(String string) throws IOException {
        if (string != null) { this.fileWriter.write(string + "\n"); }
    }
    public void Close() throws IOException { this.fileWriter.close(); }
    public String getFilename() { return filename; }
}
