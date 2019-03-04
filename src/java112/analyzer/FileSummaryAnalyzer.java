package java112.analyzer;

import java.io.*;
import java.util.*;

/**
*
* @author jpabon
*
*/

public class FileSummaryAnalyzer implements TokenAnalyzer {

    private int totalTokensCount;
    public int getTotalTokensCount() {
        return totalTokensCount;
    }

    public FileSummaryAnalyzer() {

        totalTokensCount = 0;

    }
    /**
    *
    * @param token This method will count the tokens.
    */
    public void processToken(String token) {
        totalTokensCount++;
    }
    /**
    * @param inputFilePath
    * @param summaryOutputPath
    * using bufferedWriter will write the text to an ouput stream
    * File writer is more efficient
    */
    public void generateOutputFile(String inputFilePath, String summaryOutputPath) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter("output/summary.txt")));


            displaySummary(writer);

        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
          }
          //displaySummary(writer);
      }
    /**
    *
    * @param writer
    * located the printWriter class by searching for it on Google - https://www.javatpoint.com/java-printwriter-class
    * obtained ideas from mkyong.com
    *
    */
    public void displaySummary(PrintWriter writer) {
        File f = new File("summary.txt");
        writer.println("Application: Project 1 Application");
        writer.println("Author: Jonathan Pabon");
        writer.println("Author Email: jpabon@madisoncollege.edu");
        writer.println("File: " + f.getAbsolutePath());
        writer.println("Date of analysis: " + new Date());
        writer.println("Last Modified: " + f.lastModified());
        writer.println("File Size: " + f.length());
        writer.println("File URI: file:/home/student/jonny-pabon.txt");
        writer.println("Total tokens: " + getTotalTokensCount());
    }
}
