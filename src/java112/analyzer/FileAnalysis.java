package java112.analyzer;

import java.io.*;
import java.util.*;


/**
*
* @author jpabon
*
*/
public class FileAnalysis {

    private static final int VALID_ARGUMENT_NUMBER_COUNT = 1;

    /**
    * A set that will hold all the unique tokens in the input file.
    */
    private Set<String> distinctTokens;
    /**
    *Declaring a list set that will keep tokens in the order they are read from
    * the file.
    */
    private List<String> tokens;

    private FileSummaryAnalyzer summaryAnalyzer = new FileSummaryAnalyzer();
    private DistinctTokensAnalyzer DistinctAnalyzer = new DistinctTokensAnalyzer();

    /**
    *
    * @param arguments
    *
    */
    public void analyze(String[] arguments) {

        if (arguments.length != VALID_ARGUMENT_NUMBER_COUNT) {
            System.out.println("Please enter the right input");
            return;
        }

    }
    //openInputFile(arguments[0]);

        /**
        * @param inputFilePath
        *
        */
        public void writeOutputFiles(String inputFilePath) {
            //this.generateOutputFile(inputFilePath, outputFilePath);
            //this.generateOutputFile(inputFilePath, outputFilePath);
        }
        /**
        *
        * @param inputfilePaths
        * obtained this code from my Lab four and obtained loop example from mkyong.com
        */
        private void openInputFile(String inputFilePath) {
            BufferedReader inputReader = null;
            try {
                inputReader = new BufferedReader(new FileReader("summary.txt"));
                // code to process the input file
                // declare a string variable to hold the current line
                readInputFile(inputReader);
            } catch (FileNotFoundException fileNotFound) {
                fileNotFound.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        /**
        * Reads through the input file and creates a token array for each line
        * @param inputReader the BufferedReader for the input file
        */
        public void readInputFile(BufferedReader inputReader) throws IOException {
            String line = null;
            String[] tokenArray = null;

            //Tells the stream that it's ready to be read
            while (inputReader.ready()) {
                //reading through each line
                line = inputReader.readLine();
                String[] output = line.split("\\W");

                processTokenArray(tokenArray);
            }
        }
        /**
        * Loops through the created array and filters empty tokens
        * @param tokenArray the array of tokens
        */
        public void processTokenArray(String[] tokenArray) {
            for (String token : tokenArray) {
                tokens.add(token);
                distinctTokens.add(token);
            }
        }
}
