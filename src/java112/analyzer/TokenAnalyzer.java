package java112.analyzer;

import java.io.*;
import java.util.*;
/**
*
* @author jpabon
* This is the creation of the TokenAnalyzer interface.
* It carries it's abstract methods and will be implemented by two analyzer classes
*/

public interface TokenAnalyzer {
    /**
    * This method will be called when processing the token handling
    * @param token the tokens that gets passed in
    */
    void processToken(String token);
    /**
    * This method will be called in the fileAnalysis class
    * @param inputFilePath - the file that gets read
    * @param outputFilePath - the file that will be outputted the ouput directory
    */
    void generateOutputFile(String inputfilePath, String outputFilePath);
}
