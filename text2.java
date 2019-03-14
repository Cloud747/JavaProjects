package java112.analyzer;

import java.io.*;
import java.util.*;
import java112.utilities.*;


public class LargestWords implements Parser{

    private Properties properties;
    private Set<String> largestWords;
    private int minimumWordLength;

    public Set<String> getLargestWords() {
        return largestWords;
    }
    public LargestWords() {
        words = new TreeSet<String>();
    }
    //Overloader
    public LargestWords(Properties properties) {
        this();
        this.properties = properties;
        String minimumWordLengthstnr = this.properties.getProperty("largest.words.minimum.length");
        minimumWordLength = Integer.parseInt(minimumWordLengthstnr);
    }
    public void initialize(String inputPath) {

    }
    public void nextWord(String word) {
        if (word.length() >= minimumWordLength) {
            largestWords.add(word);
        }
    }
    public void persist() {
        PrintWriter output = null;
        try {
            output = new PrintWriter(new BufferedWriter(new FileWriter(this.properties.getProperty("output.file.largest.words"))));
            this.printSummary(output);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }
    public void printSummary(PrintWriter writer) {
        for (String word : largestWords) {
            writer.println(word);
        }
    }


}
