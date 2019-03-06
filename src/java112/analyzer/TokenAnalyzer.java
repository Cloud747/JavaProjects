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
    void processToken(String token);
    void generateOutputFile(String inputfilePath, String outputFilePath);
}
