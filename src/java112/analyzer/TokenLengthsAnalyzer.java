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

    public TokenLengthsAnalyzer() {
        tokenLengths = new TreeMap<Integer, Integer>();
    }
    public TokenLengthsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    /**
    * If this has the key, it will update the count. If no key is found then add the value of 1
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
    * 
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
        
            for(Map.Entry<Integer,Integer> entry : treeMap.entrySet()) {
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
            for(Map.Entry<Integer,Integer> entry : treeMap.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                int lineLength = value / unitValue;
                
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
