package java112.analyzer;

import java.io.*;
import java.util.*;

/**
* This is another new analyzer class that will store unique tokens greater than or
* equal to a specified number.
* @author jpabon
*
*/
public class LargestTokensAnalyzer implements TokenAnalyzer{

    private Properties properties;
    private Set<String> largestTokens;
    private int minimumTokenLength;
    /**
    * This is an empty constructor. No parameters.
    */
    public LargestTokensAnalyzer() {
        largestTokens = new TreeSet<String>();
    }
    /**
    *This will return the largest tokens
    *@return largestTokens
    */
    public Set<String> getLargestTokens() {
        return largestTokens;
    }
    /**
    * Analyzer that is referencing the property reference. Obtains the property largest words
    * Example of the parstInt was explained to me on https://www.tutorialspoint.com/java/number_parseint.htm
    * @param properties passing in the properties from the property file folder
    */
    public LargestTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        String minimumTokenLengthstnr = this.properties.getProperty("largest.words.minimum.length");
        minimumTokenLength = Integer.parseInt(minimumTokenLengthstnr);
    }
    /**
     * adds tokens to the largest token array
     * @param token the obtained token
     * 
     */
    public void processToken(String token) {
        if (token.length() >= minimumTokenLength) {
            largestTokens.add(token);
        }
    }
    /**
    * This method generates the output file. Reflects the other analyzer generate output methods.
    * @param  inputFilePath file to read to
    *
    */
    public void generateOutputFile(String inputFilePath) {
        try (
            PrintWriter output = new PrintWriter(new BufferedWriter(
                    new FileWriter(this.properties.getProperty("output.directory") + this.properties.getProperty("output.file.largest.words"))))
        ) {
            for (String element : largestTokens) {
            output.println(element);
            }
        } catch (FileNotFoundException fileNotFound) {
        fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
        inputOutputException.printStackTrace();
        } catch (Exception exception) {
        exception.printStackTrace();
        }
    }
}
