import Exceptions.ClosedFileException;
import Exceptions.WrongModeException;
import entity.ParsedArgs;
import files.MyFileReader;
import sort.MergeSort;
import utils.ComparatorUtils;
import utils.Parser;

import java.io.IOException;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        try {
            ParsedArgs parsedArgs = Parser.ParseArgs(args);

            Comparator<MyFileReader> comparator = ComparatorUtils.GetComparator(parsedArgs.getMode());

            MergeSort.Sort(parsedArgs.getOutputFile(), parsedArgs.getInputFiles(), comparator);

        } catch (WrongModeException e) {
            System.out.println(e + ".\nTry these args: '[-i, -s] [-a, -d] out.txt in1.txt in2.txt ...'");
        } catch (ClosedFileException e) {
            System.out.println("(for developer) Open the file before reading it");
        } catch (IOException e) {
            System.out.println("Error :" + e);
        }
    }
}