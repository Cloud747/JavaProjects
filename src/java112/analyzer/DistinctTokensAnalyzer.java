package java112.analyzer;

import java.io.*;
import java.util.*;
/**
*
*
*/
public class DistinctTokensAnalyzer implements TokenAnalyzer {

    private Set<String> distinctTokens;

    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }
    public void DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<String>();
    }
    public void processToken(String token) {

    }
    public void generateOutputFile(String inputFilePath, String outputFilePath) {

    }
}
