package java112.analyzer;

import java.io.*;
import java.util.*;
/**
*
* @author jpabon
* This will be the holding ground for the many methods and fields
*/

public interface TokenAnalyzer {
    void processToken(String token);
    void generateOutputFile(String inputfilePath, String outputFilePath);
}
