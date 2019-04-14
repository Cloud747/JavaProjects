package java112.analyzer;

/**
 * This class will determine where search tokens are located in the input file. 
 * In this case, "where" in the file is defined to be the token count number
 * @author jpabon 
 * 
 */

public class TokenLocationSearchAnalyzer {

    private Map<String, List<Integer>> foundLocations;
    private Properties properties;
    private int currentTokenLocation;

    /**
     * 
     * 
     * @return foundLocations 
     */
    public Map<String, List<Integer>> getFoundLocations() {
        return foundLocations;
    }
}