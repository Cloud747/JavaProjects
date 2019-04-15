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
    * @param  inputFilePath file to read to
    *
    */
    


}
