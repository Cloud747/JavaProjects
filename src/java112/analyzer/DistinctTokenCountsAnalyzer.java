package java112.analyzer;

import java.io.*;
import java.util.*;
/**
* This new analyzer will count the number of unique tokens
* @author jpabon
*/
public class DistinctTokenCountsAnalyzer implements TokenAnalyzer{
    private Properties properties;
    private Map<String, Integer> distinctTokenCounts;

    /**
    * This is an empty constructor
    * Initialized the distinct token counts
    */
    public DistinctTokenCountsAnalyzer() {
        distinctTokenCounts = new HashMap<String, Integer>(100);
    }
    /**
    * This will return the
    * @return distinctTokenCounts
    */
    public Map<String, Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }
    /**
    * Analyzer that is referencing the property reference
    * @param properties the objects from the property file 
    */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    /**
    * Checking to see if the token has been checked before. If so, increments 
    * the count. If not, it will add it into Distinct token with a value of 1.
    * Yet another great example found from Tutorials point: http://www.tutorialspoint.com/java/util/hashmap_containskey.htm
    *  @param token the token count
    */
    public void processToken(String token) {
        if (distinctTokenCounts.containsKey(token)){
            int count = distinctTokenCounts.get(token);
            distinctTokenCounts.put(token, ++count);
        }
        else {
            distinctTokenCounts.put(token,1);
        }
    }
    /**
    * This method generates the output file. Using the EntrySet 
    * Took the example from http://paulawaite.com/education/java112/unit2/treeMapDemo/
    * 
    * @param  inputFilePath file to read to
    */
    public void generateOutputFile(String inputFilePath) {
        try (
            PrintWriter output = new PrintWriter(new BufferedWriter(
                    new FileWriter(this.properties.getProperty("output.directory") + this.properties.getProperty("output.file.distinct.counts"))))
        ) {
            //Entry set returns a set of map.entry (which is a key value pair)
            TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(distinctTokenCounts);
            for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
                //displaying each of the map entry. 
                output.println(entry.getKey() + "\t" + entry.getValue());
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
