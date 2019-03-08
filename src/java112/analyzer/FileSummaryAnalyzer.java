package java112.analyzer;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

/**
* This class will read the input file then wrtie the summary report to an output file.
* @author jpabon
*
*/

public class FileSummaryAnalyzer implements TokenAnalyzer {
    //Creating the instance variables
    private int totalTokensCount;
    /**
    * Here is where you will be initiailizing the totalTokensCount to 0
    */
    public FileSummaryAnalyzer() {
        totalTokensCount = 0;
    }
    /**
    * The getter method for obtaining the totalTokensCount
    * @return totalTokensCount The amount of tokens will be returned
    */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }

    /**
    * This method will simply increment the counter when a token has been added
    * to the set created in the DistinctTokensAnalyzer.
    * @param token passing in a string token
    */
    public void processToken(String token) {
        totalTokensCount++;
    }
    /**
    * using bufferedWriter will write the text to an ouput stream
    * File writer is more efficient
    * @param inputFilePath the input file name
    * @param summaryOutputPath the output file name
    */
    public void generateOutputFile(String inputFilePath, String summaryOutputPath) {
        try (
            BufferedReader input = new BufferedReader(new FileReader(inputFilePath));
            PrintWriter output = new PrintWriter(new BufferedWriter(
                    new FileWriter(summaryOutputPath)))
        ) {
            while (input.ready()) {
                output.println(input.readLine());
            }
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
    /**
    * This method will display the defined values from the project requirements.
    * located the printWriter class by searching for it on Google - https://www.javatpoint.com/java-printwriter-class
    * obtained ideas from mkyong.com
    * @param writer uses the PrintWriter package
    * @param inputFilePath the input file that is being passed in.
    */

    public void displaySummary(PrintWriter writer, String inputFilePath) {

        File f = new File(inputFilePath);
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
