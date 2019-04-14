package java112.analyzer;



/**
* This analyzer will determine the length 
* distribution of the tokens in the input 
* file and display the distribution in two formats
* @author jpabon
* 
*/
public class TokenLengthsAnalyzer {
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
}
