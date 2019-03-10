package java112.analyzer;

import java.io.*;
import java.util.*;


/**
* This class has several methods that will call the read and write methods along with
* setting the file route for both the input and output files.
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
            System.out.println("Please enter one argument on the command line, and input file name");
        } else {
            newObjects();
            openInputFile(arguments[0]);
            writeOutputFiles(arguments[0]);
        }
    }
        /**
        * This method will ensure the ensure the routing of these files is
        * correct.
        * @param inputFilePath passing in the inputfilepath
        *
        */
        public void writeOutputFiles(String inputFilePath) {
            //Talked this over with Kevin from class and he gave me some hints on
            //finding the missing chacter.
            //Declaring the output files for each analyzer class object
            String summaryOutputPath = "output/summary.txt";
            String distinctOutputPath = "output/distinct_tokens.txt";
            //calling each analyzer with the generateOutputFile method
            summaryAnalyzer.generateOutputFile(inputFilePath, summaryOutputPath);
            distinctAnalyzer.generateOutputFile(inputFilePath, distinctOutputPath);
        }
        /**
        * Opens the input file and then storing the inputFilePath
        * obtained this code from my Lab four and obtained loop example from mkyong.com
        * @param inputFilePath passing in the inputFilePath
        *
        */
        private void openInputFile(String inputFilePath) {
            try (
                BufferedReader inputReader = new BufferedReader(new FileReader(inputFilePath))) {
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
                //Tells the stream that it's ready to be read
                while (inputReader.ready()) {
                //reading through each line
                    line = inputReader.readLine();
                //used for parsing the tokens
                    String[] tokens = line.split("\\W");
                    //calling the emptyTokenCheck method which checks for empt
                    emptyTokenCheck(tokens);
                }
        }
        /**
        * This method gets called when no empty tokens are found.
        * @param token the tokens passed in.
        */
        public void processTokens(String token) {
                distinctAnalyzer.processToken(token);
                summaryAnalyzer.processToken(token);
        }
        /**
        * The machine that will check for empty tokens(keeps the distinct_tokens file from starting
        * out with a blank field)
        * @param tokens the tokens that are passed in are parsed.
        **/
        public void emptyTokenCheck(String[] tokens) {
            //The for loop that will check through the tokens array
            for (String element : tokens) {
                if (!element.isEmpty()) {
                    processTokens(element);
                }
            }
        }
}
