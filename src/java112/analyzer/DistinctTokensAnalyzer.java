package java112.analyzer;

import java.io.*;
import java.util.*;
/**
* @author jpabon
* This class will implement the TokenAnalyzer. This class will have tokens passed
* to it, then it will be appended to the treeset. It will then gather the tokens and
* output them to the output file.
*/
public class DistinctTokensAnalyzer implements TokenAnalyzer {

    //Creating the instance variables for this class.
    private Set<String> distinctTokens;
    /**
    * @return distinctTokens
    * This will returns tokens to the treeset
    */
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }
    /**
    * This is the empty constructor. It is being used for initiailizing the
    * treeset.
    */
    public DistinctTokensAnalyzer() {
         distinctTokens = new TreeSet<String>();
    }
    /**
    * @param token This is the tokens in the treeset
    * This will add tokens to the distinct Set
    */
    public void processToken(String token) {
        distinctTokens.add(token);
    }
    /**
    * @param  inputFilePath file to read to
    * @param distinctOutputPath file output
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
