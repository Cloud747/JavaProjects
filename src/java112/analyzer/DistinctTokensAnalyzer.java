package java112.analyzer;

import java.io.*;
import java.util.*;
/**
* This class will implement the TokenAnalyzer. This class will have tokens passed
* to it, then it will be appended to the treeset. It will then gather the tokens and
* output them to the output file.
* @author jpabon
*/
public class DistinctTokensAnalyzer implements TokenAnalyzer {

    //Creating the instance variables for this class.
    private Set<String> distinctTokens;
    /**
    * This is the empty constructor. It is being used for initiailizing the
    * treeset.
    */
    public DistinctTokensAnalyzer() {
         distinctTokens = new TreeSet<String>();
    }
    /**
    * This will returns tokens to the treeset
    * @return distinctTokens
    */
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }

    /**
    * This will add tokens to the distinct Set
    * @param token This is the tokens in the treeset
    */
    public void processToken(String token) {
        distinctTokens.add(token);
    }
    /**
    * This method generates the output file
    * @param  inputFilePath file to read to
    * @param distinctOutputPath file output
    *
    */
    public void generateOutputFile(String inputFilePath, String distinctOutputPath) {
        //TODO try with resources
        PrintWriter outputWriter = null;

        try {
            outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(distinctOutputPath)));
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
