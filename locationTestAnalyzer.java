package java112.analyzer;
	
	import java.io.*;
	import java.util.*;
	import java112.utilities.*;
	
	/**
	* The class will load a file of search tokens, parse the file and store all the
	* them in a Map. The map will use each search token as the key to an element and
	* an empty ArrayList of Integers as the element’s value.
	*
	*/
	
	public class TokenLocationSearchAnalyzer implements TokenAnalyzer {
	
	 //instance variables
        private Map<String, List<Integer>> foundLocations;
        private Properties properties;
        private int currentTokenLocation;
	
	 /**
	 * empty constructor
	 **/
	 public TokenLocationSearchAnalyzer() {
	     foundLocations = new TreeMap<String, List<Integer>>();
	 }
	
	 /**
	 * @param properties analyzer properties file
	 **/
	 public TokenLocationSearchAnalyzer(Properties properties) {
	    this();
	    this.properties = properties;
	    currentTokenLocation = 0;
	    readPropFile();
	 }
	
	 /**
	 *
	 **/
	 public Map<String, List<Integer>> getFoundLocations() {
	    return foundLocations;
	 }
	
	 /**
	 * @param token string token to process
	 **/
	 public void processToken(String token) {
	    currentTokenLocation++;
	    System.out.println(token);
        
	    if (getFoundLocations().containsKey(token) == true) {
	    //if key exists, grab list as value and add currentTokenLocation
	        getFoundLocations().get(token).add(currentTokenLocation);
	    }
	 }
	
	 public void readPropFile() {
	
        String propertyFile = properties.getProperty("classpath.search.tokens");
        
        try (InputStream inputStream = this.getClass().getResourceAsStream(propertyFile);
        
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader searchTokensReader = new BufferedReader(inputStreamReader)) {
            
            readSearchTokens(searchTokensReader);
        
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
	 }
	
	 public void readSearchTokens(BufferedReader reader) throws IOException {
	
        System.out.println("Hello in readSearchTokens Method");
        
        while (reader.ready()) {
            String line = reader.readLine();
            String[] tokens = line.trim().split("\\s*,\\s");
            checkAgainstProcessedTokens(tokens);
        }
	 }
	
	 public void checkAgainstProcessedTokens(String[] tokens) {
        //for each item in the array
        List<Integer> mapList = new ArrayList<Integer>();
        
        for (String element : tokens) {
            if (element.isEmpty() == false) {
        
                if (getFoundLocations().containsKey(element) == false) {
                    getFoundLocations().put(element, mapList);
                }
            }
        }
	 }
	
	 /**
	 * @param inputFilePath commandline file
	 **/
	 public void generateOutputFile(String inputFilePath) {
	
	    int tokenLength = 0;
	    int cummTokenLength = 0;
	
        //get the output file property
        String outputFile = properties.getProperty("output.directory")
        + properties.getProperty("output.file.token.search.locations");
        
        //create PrintWriter object with try-with-resources statements
        try ( PrintWriter outputWriter =
        new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))) {
        
            //for each key-value pair, output the key and value
            for (Map.Entry<String, List<Integer>> entry : getFoundLocations().entrySet()) {
            
                outputWriter.println(entry.getKey() + " =");
            
                outputWriter.print("[");
            
                if (entry.getValue().size() == 0) {
                    outputWriter.print("]");
                    outputWriter.println();
                } else {
            
                    for (int i = 0; i < entry.getValue().size(); i++) {
                    
                        outputWriter.print(entry.getValue().get(i));
                    
                        if (i == (entry.getValue().size() - 1)) {
                            outputWriter.print("]");
                            outputWriter.println();
                        } else if (i == 20 || i == 40) {
                            outputWriter.print(", ");
                            outputWriter.println();
                        } else {
                            outputWriter.print(", ");
                        }
                    }
                }
                outputWriter.println();
            }
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}