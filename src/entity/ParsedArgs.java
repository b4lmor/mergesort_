package entity;

import enums.SortMode;

import java.util.ArrayList;
import java.util.List;

public class ParsedArgs {
    private SortMode mode;
    private String outputFile;
    private final List<String> inputFiles;

    public ParsedArgs() {
        this.inputFiles = new ArrayList<>();
    }

    public SortMode getMode() { return mode; }

    public List<String> getInputFiles() { return inputFiles; }

    public String getOutputFile() { return outputFile; }

    public void setMode(SortMode mode) { this.mode = mode; }

    public void addInputFiles(String inputFile) { this.inputFiles.add(inputFile); }

    public void setOutputFile(String outputFile) { this.outputFile = outputFile; }
}
