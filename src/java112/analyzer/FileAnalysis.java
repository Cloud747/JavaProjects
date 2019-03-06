package java112.analyzer;

import java.io.*;
import java.util.*;


/**
*
* @author jpabon
*
*/
public class FileAnalysis {

    //Creating the constant
    private static final int VALID_ARGUMENT_NUMBER_COUNT = 1;
    //Creating the variables
    private FileSummaryAnalyzer summaryAnalyzer;
    private DistinctTokensAnalyzer distinctAnalyzer;
    /**
    * This run method will instantiate the analyzers
    */
    public void newObjects() {

        summaryAnalyzer = new FileSummaryAnalyzer();
        distinctAnalyzer = new DistinctTokensAnalyzer();
    }
    /**
    * This analze method will check to ensure the correct number of input has been made.
    * It will also call upon the newObjects method. It will then verify the command readLine
    * argument. The openInputFile is also called here too.
    * @param arguments the command line arguments
    *
    */
    public void analyze(String[] arguments) {

        if (arguments.length != VALID_ARGUMENT_NUMBER_COUNT) {
            System.out.println("Please enter the right input");

        } else {
            newObjects();
            openInputFile(arguments[0]);
        }
    }
        /**
        * This method will ensure the ensure the routing of these files is
        * correct.
        * @param inputFilePath
        *
        */
        public void writeOutputFiles(String inputFilePath) {

            //Declaring the output files for each analyzer class object
            String summaryOutputPath = "/output/summary.txt";
            String distinctOutputPath = "/output/distinct_tokens.txt";
            //calling each analyzer with the generateOutputFile method
            summaryAnalyzer.generateOutputFile(inputFilePath, summaryOutputPath);
            distinctAnalyzer.generateOutputFile(inputFilePath, distinctOutputPath);
        }
        /**
        * Opens the input file and then storing the inputFilePath
        * @param inputfilePath
        * obtained this code from my Lab four and obtained loop example from mkyong.com
        */
        private void openInputFile(String inputFilePath) {
            BufferedReader inputReader = null;
            try {
                inputReader = new BufferedReader(new FileReader(inputFilePath));
                // code to process the inDistinctTokensAnalyzerput file
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
        * @throws IOException this is used to catch the IOException and handle it
        */
        public void readInputFile(BufferedReader inputReader) throws IOException {

            //Creating this string to point to nothing - more as a storage
            String line = null;

            try {
                //Tells the stream that it's ready to be read
                while (inputReader.ready()) {
                //reading through each line
                    line = inputReader.readLine();
                //used for parsing the tokens
                    String[] tokenArray = line.split("\\W");

                    processTokens(tokenArray);
                }
            }  catch (FileNotFoundException fileNotFound) {
                fileNotFound.printStackTrace();
            } catch (IOException inputOutputException) {
                inputOutputException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        /**
        * Loops through the created array and filters empty tokens (token is being passed)
        * processing the tokens
        * @param tokenArray the array of tokens
        */
        public void processTokens(String[] tokenArray) {

            for (int i = 0; i < tokenArray.length; i++) {
                distinctAnalyzer.processToken(tokenArray[i]);
                summaryAnalyzer.processToken(tokenArray[i]);
            }
        }
}
