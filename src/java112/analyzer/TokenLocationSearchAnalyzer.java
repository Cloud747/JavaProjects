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
    * LinkedHashMap created to ensure values were maintained in the order they were added.
    * 
    */
    public TokenLocationSearchAnalyzer() {
        foundLocations = new LinkedHashMap<String, List<Integer>>();
        currentTokenLocation = -1;
    }
    /**
    * Analyzer that is referencing the property reference
    * @param properties the objects from the property file 
    */
    public TokenLocationSearchAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        readInSearchTokens();
    }
    /**
     * 
     * 
     * @param token processing the string token from the input file. Updating the current token location.
     * As we process it, we are updating the location of the token. List of all the locations of where it was found.
     */
    public void processToken(String token) {
        currentTokenLocation++;
        if (foundLocations.containsKey(token)) {
            List<Integer> list = foundLocations.get(token);
            list.add(currentTokenLocation);
        } 
    }
    /**
     *  Used code from http://paulawaite.com/education/java112/unit3/classpath-loading/ 
     * Reading the search tokens file from the classpath and read line by line but each line may have multiple tokens, but we are splitting them into separate
     * tokens. For every search token, created an empty list of found locations.
     * 
     */
    public void readInSearchTokens() {
        String propFile = properties.getProperty("classpath.search.tokens");
        //Try with resources
        try (InputStream inputStream = this.getClass().getResourceAsStream(propFile);
            
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader searchTokensReader = new BufferedReader(inputStreamReader)) {
            //Tells the stream that it is ready to be read
            while (searchTokensReader.ready()) {
                String line = searchTokensReader.readLine();
                //eliminating leading and trailing spaces with trim and split
                //creating a string array of tokens
                String[] tokens = line.trim().split("\\s*,\\s");
                List<Integer> lArray = new ArrayList<Integer>();
                // Notes: String is the type - element is the identifier. Tokens is the name
                for (String element : tokens) {
                    if (element.isEmpty() == false) {
                        //using containsKey to ensure the FoundLocations is in the tokens array
                        if (getFoundLocations().containsKey(element) == false) {
                            getFoundLocations().put(element, lArray);
                        }
                    }
                }
            }
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
     }
    /**
     * 
     * For this method, it goes through the entry set and I used a linked hash map to maintain the order it was going to be displayed in.
     * Found help through https://www.mkyong.com/java/java-how-to-iterate-a-hashmap/
     * @param inputFilePath processing the string token
     */
	 public void generateOutputFile(String inputFilePath) {
        
        String outputFile = properties.getProperty("output.directory")
        + properties.getProperty("output.file.token.search.locations");
        
        ArrayList<String> lines = new ArrayList<String>();
        try ( PrintWriter outputWriter =
            new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))) {
        
            //using the map.entry for the key-value pair and to ensure we can work with the map entry. Entryset method will return the map entries
            for (Map.Entry<String, List<Integer>> entry : getFoundLocations().entrySet()) {
                // If the key is empty - it gets ignored and continues on.
                if (entry.getKey().trim().length() < 1) {
                    //found continue https://www.javatpoint.com/java-continue - was looking for a way to continue if the entry is less than 1
                    continue;
                }
                //using the getKey method to fetch the set of entries
                String line = entry.getKey() + " =";
                // adding the line to the string arraylist
                lines.add(line);
                line = "[";
                // If the location list is empty we add the line and close off the locations. 
                if (entry.getValue().size() == 0) {
                    line += "]";
                    lines.add(line);
                    lines.add("");
                } else {
                    // loop through all the locations and keep line under 80 characters. Checking all the values and size
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        //Declaring location as the value
                        String location = "" + entry.getValue().get(i);
                        // if i is equal to 0, then you are displaying the first of the positions in the list so you can append it to the position
                        if (i == 0) {
                            line += location;
                        }
                        //Added the else if if you are about to exceed 80 characters in your line, then you close the line and begin a new line
                        else if (line.length() + location.length() + 2 > 80) {
                            lines.add(line);
                            line = location;
                        }
                        //Added the else if you are not at the beginning of the locations nor at the end of the line, you just append a comma and space and the location.
                        else {
                            line += ", " + location;
                        }
                        //Checking to see if that was the last entry then close the bracket
                        if (i == (entry.getValue().size() - 1)) {
                            line += "]";
                            lines.add(line);
                            lines.add("");
                        }
                    }
                }
            }
            for (String line : lines) {
                //Trying out this typechar character for automatic string conversion
                outputWriter.printf("%s\n", line);
            }
            outputWriter.println();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }    
}