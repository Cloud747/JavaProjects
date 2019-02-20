package java112.analyzer;

import java.io.*;
import java.util.*;
/**
*
* @author jpabon
*
*/

public interface TokenAnalyzer {
    void processToken(String token);
    void generateOutputFile(String inputfilePath, String outputFilePath);
}
    
