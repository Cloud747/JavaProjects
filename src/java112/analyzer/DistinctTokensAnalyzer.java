package java112.analyzer;

import java.io.*;
import java.util.*;
/**
* This class implements the TokenAnalyzer.
* What it does:
*/
public class DistinctTokensAnalyzer implements TokenAnalyzer {

    private Set<String> distinctTokens;
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }
    public DistinctTokensAnalyzer() {
         distinctTokens = new TreeSet<String>();

    }
    /**
    * @param String token
    * This will add tokens to the distinct Set
    */
    public void processToken(String token) {
        distinctTokens.add(token);
    }
    /**
    * @param String inputFilePath
    * @param String distinctOutputPath
    * This method generates the output file
    */
    public void generateOutputFile(String inputFilePath, String distinctOutputPath) {
        PrintWriter outputWriter = null;
        try {
            outputWriter = new PrintWriter(new BufferedWriter(new FileWriter("output/distinct_tokens.txt")));
            for (String element : distinctTokens) {
                outputWriter.println(element);
            }
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (outputWriter != null) {
                outputWriter.close();
            }
        }
    }
}
