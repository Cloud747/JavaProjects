package java112.analyzer;

import java.io.*;
import java.util.*;
/**
* This is the creation of the TokenAnalyzer interface.
* It carries it's abstract methods and will be implemented by two analyzer classes
* @author jpabon
*/

public interface TokenAnalyzer {
    /**
    * This is the processToken method that gets used in both anaylyzers and file Summary class
    * @param token The tokens being passed into this method
    */
    void processToken(String token);
    /**
    * This is the generateOutputFile method that gets used in both anaylyzers and file Summary class
    * @param inputFilePath This is going to be used as a paramter to pass in the inputFilePath
    */
    void generateOutputFile(String inputFilePath); //had it shown as String outputFilePath
}
