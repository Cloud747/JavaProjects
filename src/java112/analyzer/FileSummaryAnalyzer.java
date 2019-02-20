package java112.analyzer;

import java.io.*;
import java.util.*;

/**
*
* @author jpabon
* checked the site
*/

public class FileSummaryAnalyzer implements TokenAnalyzer {

    private int totalTokensCount;

    public int getTotalTokenCount() {
        return totalTokensCount;
    }
    public void FileSummaryAnalyzer() {

    }
    public void processToken(String token) {

    }
    public void generateOutputFile(String inputFilePath, String outputFilePath) {

    }
    /**
    *
    * @param writer
    * located the printWriter class by searching for it on Google - https://www.javatpoint.com/java-printwriter-class
    * obtained ideas from mkyong.com
    *
    */
    public void displaySummary(PrintWriter writer) {
        File f = new File(this.inputFilePath);
        writer.println("Application: Project 1 Application");
        writer.println("Author: Jonathan Pabon");
        writer.println("Author's Email: jpabon@madisoncollege.edu");
        writer.println("File: " + );
        writer.println("Date of analysis: " + new Date());
        writer.println("Last Modified: " + f.lastModified());
        writer.println("File Size: " + f.length());
        writer.println("File URI: file:/home/student/jonny-pabon.txt");
        writer.println("Total tokens: " + );
    }
}
