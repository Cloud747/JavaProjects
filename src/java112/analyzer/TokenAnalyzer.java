package java112.analyzer;

import java.io.*;
import java.util.*;
/**
*
*
*
*/
public interface TokenAnalyzer {
    void processToken(String token);
    void generateOutputFile(String inputfilePath, String outputFilePath);
}
