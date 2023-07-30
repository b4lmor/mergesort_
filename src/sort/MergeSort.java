package sort;

import Exceptions.ClosedFileException;
import files.MyFileReader;
import files.MyFileWriter;

import java.io.IOException;
import java.util.*;

public class MergeSort {
    public static void Sort(String outputFilename,
                                List<String> inputFilenames,
                                Comparator<MyFileReader> comparator
                                ) throws IOException, ClosedFileException {

        MyFileWriter outputFileWriter = new MyFileWriter(outputFilename);
        Queue<MyFileReader> inputFileReaders = new PriorityQueue<>(inputFilenames.size(), comparator);
        for (String filename : inputFilenames) { inputFileReaders.add(new MyFileReader(filename)); }

        while (inputFileReaders.size() != 0) {
            MyFileReader bufFileReader = inputFileReaders.poll();
            if (bufFileReader.getValue() != null) { outputFileWriter.Write(bufFileReader.getValue()); }
            if (bufFileReader.Read() == null) { bufFileReader.Close(); }
            else { inputFileReaders.add(bufFileReader); }
        }
        outputFileWriter.Close();
    }

}
