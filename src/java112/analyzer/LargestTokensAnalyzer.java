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
    * This is an empty constructor.
    *
    */
    public LargestTokensAnalyzer() {

    }
    /**
    * Analyzer that is referencing the property reference
    * @param properties
    */
    public LargestTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        String minimumTokenLengthstnr = this.properties.getProperty("largest.words.minimum.length");
        minimumTokenLength = Integer.parseInt(minimumTokenLengthstnr);
        largestTokens = new TreeSet<String>();
    }
    /**
    * This will return
    *@return largestTokens
    */
    public Set<String> getLargestTokens() {
        return largestTokens;
    }

    public void processToken(String token) {
        if (token.length() >= minimumTokenLength) {
            largestTokens.add(token);
        }
    }

    /**
    * This method generates the output file
    * @param  inputFilePath file to read to
    * @param distinctOutputPath file output
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