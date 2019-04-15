package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * This class will determine where search tokens are located in the input file. 
 * In this case, "where" in the file is defined to be the token count number
 * @author jpabon 
 * 
 */

public class TokenLocationSearchAnalyzer implements TokenAnalyzer{

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
    /**
    * This will return the
    * 
    */
    public TokenLocationSearchAnalyzer() {
        foundLocations = new TreeMap<String, List<Integer>>();
        currentTokenLocation = -1;
    }
    /**
    * Analyzer that is referencing the property reference
    * @param properties the objects from the property file 
    */
    public TokenLocationSearchAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    public void processToken(String token) {
        currentTokenLocation++;
        if (foundLocations.containsKey(token) {
            List<Integer> list = foundLocations.get(token);
            list.add(currentTokenLocation);
        } 
    }
    public void generateOutputFile(String inputFilePath) {
        try (
            PrintWriter output = new PrintWriter(new BufferedWriter(
                    new FileWriter(this.properties.getProperty("output.directory") + this.properties.getProperty("output.file.token.lengths"))))
        ) {
            TreeMap<String,List<Integer>> treeMap = (TreeMap<String, List<Integer>>)foundLocations;

            int longestLine = 0;
        
            for(Map.Entry<String, List<Integer>> entry : treeMap.entrySet()) {
                String key = entry.getKey();
                List<Integer> value = entry.getValue();
                
                output.println(key + "=[");
                String line = "";
                for (Integer element : value) {
                    line += "" + element + ", ";
                    if (line.length > 70) {
                        
                    }
                }
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