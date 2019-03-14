package java112.analyzer;

import java.io.*;
import java.util.*;
/**
* This new analyzer will count the number of unique tokens
* @author jpabon
*
*/
public class DistinctTokenCountsAnalyzer implements TokenAnalyzer{
    private Properties properties;
    private Map<String, Integer> distinctTokenCounts;

    /**
    * This is an empty constructor
    *
    */
    public DistinctTokenCountsAnalyzer() {
        distinctTokenCounts = new HashMap<String, Integer>();
    }
    /**
    *
    * This will return the
    * @return distinctTokenCounts
    */
    public Map<String, Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }
    /**
    *
    *
    *
    */
    public void processToken(String token) {
        distinctTokenCounts.put(token,1);

    }
    /**
    * Analyzer that is referencing the property reference
    * @param properties
    */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
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
                    new FileWriter(this.properties.getProperty("output.directory") + this.properties.getProperty("output.file.distinct.counts"))))
        ) {
            //for (String element : distinctTokenCounts) {
            //output.println(element);
            //}
        } catch (FileNotFoundException fileNotFound) {
        fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
        inputOutputException.printStackTrace();
        } catch (Exception exception) {
        exception.printStackTrace();
        }
    }
}
