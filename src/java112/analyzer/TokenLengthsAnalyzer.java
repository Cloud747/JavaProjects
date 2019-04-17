package java112.analyzer;

import java.io.*;
import java.util.*;

/**
* This analyzer will determine the length 
* distribution of the tokens in the input 
* file and display the distribution in two formats
* @author jpabon
* 
*/
public class TokenLengthsAnalyzer implements TokenAnalyzer {
    //Adding the following instance variables
    private Map<Integer, Integer> tokenLengths;
    private Properties properties;

    /**
    * 
    * @return tokenLengths
    */
    public Map<Integer, Integer> getTokenLengths() {
        return tokenLengths;
    }
    /**
     * 
     * Constructed a new treemap
     */
    public TokenLengthsAnalyzer() {
        tokenLengths = new TreeMap<Integer, Integer>();
    }
    /**
     *  Analyzer that is referencing the property reference
     * 
     * @param properties loading values from the properties 
     */
    public TokenLengthsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    /**
    * If this has the key, it will update the count. If no key is found then add the value of 1
    * Obtained some idea flow by https://stackoverflow.com/questions/1318980/how-to-iterate-over-a-treemap
    * @param token 
    */
    public void processToken(String token) {
        if (tokenLengths.containsKey(token.length())) {
            int count = tokenLengths.get(token.length());
            tokenLengths.put(token.length(), ++count);
        } else {
            tokenLengths.put(token.length(), 1);
        }
    }
     /**
    * Get the longest line to determine the unit value of an asterisk. 
    * @param  inputFilePath 
    * 
    */
    public void generateOutputFile(String inputFilePath) {
        try (
            PrintWriter output = new PrintWriter(new BufferedWriter(
                    new FileWriter(this.properties.getProperty("output.directory") + this.properties.getProperty("output.file.token.lengths"))))
        ) {
            TreeMap<Integer, Integer> treeMap = (TreeMap<Integer, Integer>)tokenLengths;

            int longestLine = 0;
            
            // Iterating to display the key and length. Used the loop to get the longest line.Using
            // map entry with a key value pair
            for (Map.Entry<Integer,Integer> entry : treeMap.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                if (value > longestLine) {
                    longestLine = value;
                }
                output.println(key + "\t" + value);
            }
            int unitValue = longestLine / 80;
            if (unitValue < 1) {
                unitValue = 1;
            }
            // This loop is to display the histogram. Displayed one asterisk per unit value. Took the count of the word length and divided it by the unit value
            // to determine how many asterisks to show in the histogram. 
            for(Map.Entry<Integer,Integer> entry : treeMap.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                int lineLength = value / unitValue;
                //this calculation is to ensure that each number is given at least an * if it has a remainder
                if (value % unitValue != 0) {
                    lineLength += 1;
                }
                //Calculation for incrementing the *
                String line = "";
                for (int i = 0; i < lineLength; i++) {
                    line += "*";
                }
                output.println(key + "\t" + line);
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
