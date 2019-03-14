package java112.analyzer;

import java.util.*;
import java.io.*;
/**
* @author jpabon
* The WordCollection class portion
*/
public class WordCollection implements Parser {

    //Only allow instance variables here
    private Set<String> words;
    private Properties properties;
    public Set<String> getWords() {
        return words;
    }
    public WordCollection() {
        //creating the Treeset object
        words = new TreeSet<String>();
    }
    public WordCollection(Properties properties) {
        this();
        this.properties = properties;
    }

    public void initialize(String inputPath) {
    }

    public void nextWord(String word) {
        words.add(word);
    }

    //public void onProgress(int count, String message) {}

    /**
    * This method will handle any expected errors with try and catch resources
    * @param outputPath This is the outputPath
    *
    */
    public void persist() {
        PrintWriter output = null;
        try {
            output = new PrintWriter(new BufferedWriter(new FileWriter(this.properties.getProperty("output.file.collections"))));
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
    /**
    * This method will print out set string of words
    * @param writer This is the writer parameter
    *
    */
    public void printSummary(PrintWriter writer) {
        for (String word : words) {
            writer.println(word);
        }
    }
}
