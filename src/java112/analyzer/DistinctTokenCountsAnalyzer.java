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
    * Analyzer that is referencing the property reference
    * @param properties the objects from the property file 
    */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }
    /**
    * This method generates the output file.
    * Added iterator to the Map (needs direction) in order to get the values, you have to get the entry set and from that you 
    * can use the iterator interface to look at the values in the set. Converted to a TreeMap.
    * Iterator example was found on Github and some other tutorials point https://www.tutorialspoint.com/java/java_using_iterator.htm
    * @param  inputFilePath file to read to
    */
    public void generateOutputFile(String inputFilePath) {
        try (
            PrintWriter output = new PrintWriter(new BufferedWriter(
                    new FileWriter(this.properties.getProperty("output.directory") + this.properties.getProperty("output.file.distinct.counts"))))
        ) {
            Set keySet = new TreeMap(distinctTokenCounts).keySet();
            Iterator iterator = keySet.iterator();
            while(iterator.hasNext()) {
                String key = (String)iterator.next();
                output.println(key + "\t" + distinctTokenCounts.get(key));
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
