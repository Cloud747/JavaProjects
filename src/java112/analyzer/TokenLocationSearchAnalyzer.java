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
     */
    public void readInSearchTokens() {
	
        String propertyFile = properties.getProperty("classpath.search.tokens");
        
        try (InputStream inputStream = this.getClass().getResourceAsStream(propertyFile);
        
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader searchTokensReader = new BufferedReader(inputStreamReader)) {
            
            while (searchTokensReader.ready()) {
                String line = searchTokensReader.readLine();
                //eliminating leading and trailing spaces with trim and split
                String[] tokens = line.trim().split("\\s*,\\s");
                List<Integer> lArray = new ArrayList<Integer>();
                
                for (String element : tokens) {
                    if (element.isEmpty() == false) {
                
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
     * @param inputFilePath processing the string token
     */
	 public void generateOutputFile(String inputFilePath) {
        
        String outputFile = properties.getProperty("output.directory")
        + properties.getProperty("output.file.token.search.locations");


        ArrayList<String> lines = new ArrayList<String>();
        
        
        try ( PrintWriter outputWriter =
        new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))) {
        
            
            for (Map.Entry<String, List<Integer>> entry : getFoundLocations().entrySet()) {
                // If the key is empty - it gets ignored and continues on.
                if (entry.getKey().trim().length() < 1) {
                    continue;
                }
                
                String line = entry.getKey() + " =";
                lines.add(line);
                line = "[";
                // If the location list is empty we add the line and close off the locations. 
                if (entry.getValue().size() == 0) {
                    line += "]";
                    lines.add(line);
                    lines.add("");
                } else {
                    // loop through all the locations and keep line under 80 characters
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        
                        String location = "" + entry.getValue().get(i);
                        if (i == 0) {
                            line += location;
                        }
                        else if (line.length() + location.length() + 2 > 80) {
                            lines.add(line);
                            line = location;
                        }
                        else {
                            line += ", " + location;
                        }
                        if (i == (entry.getValue().size() - 1)) {
                            line += "]";
                            lines.add(line);
                            lines.add("");
                        }
                    }
                }
            }
            for (String line : lines) {
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