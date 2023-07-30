package utils;

import enums.SortMode;
import files.MyFileReader;

import java.util.Comparator;

public class ComparatorUtils {
    public static Comparator<MyFileReader> GetComparator(SortMode mode) {
        return switch (mode) {
            case INT_ASC -> new Comparator<MyFileReader>() {
                @Override
                public int compare(MyFileReader o1, MyFileReader o2) {
                    if (o1.getValue() == null) { return -1; }
                    if (o2.getValue() == null) { return 1; }
                    return Integer.parseInt(o1.getValue()) - Integer.parseInt(o2.getValue());
                }
            };
            case INT_DESC -> new Comparator<MyFileReader>() {
                @Override
                public int compare(MyFileReader o1, MyFileReader o2) {
                    if (o1.getValue() == null) { return -1; }
                    if (o2.getValue() == null) { return 1; }
                    return Integer.parseInt(o2.getValue()) - Integer.parseInt(o1.getValue());
                }
            };
            case STRING_ASC -> new Comparator<MyFileReader>() {
                @Override
                public int compare(MyFileReader o1, MyFileReader o2) {
                    if (o1.getValue() == null) { return -1; }
                    if (o2.getValue() == null) { return 1; }
                    return o1.getValue().compareTo(o2.getValue());
                }
            };
            case STRING_DESC -> new Comparator<MyFileReader>() {
                @Override
                public int compare(MyFileReader o1, MyFileReader o2) {
                    if (o1.getValue() == null) { return -1; }
                    if (o2.getValue() == null) { return 1; }
                    return o2.getValue().compareTo(o1.getValue());
                }
            };
        };
    }
}
