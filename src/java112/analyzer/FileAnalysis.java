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
    private FileSummaryAnalyzer summaryAnalyzer = new FileSummaryAnalyzer();
    private DistinctTokenAnalyzer DistinctAnalyzer = new DistinctTokenAnalyzer();

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
        /**
        * @param args
        *
        */
        void openInputFile(String inputFilePath) {

        }
        void writeOutputFiles() {
            this.generateOutputFile();
        }
        public void run(String testFile) {
            BufferedReader inputReader = null;
            try {
                inputReader = new BufferedReader(new FileReader(testFile));
                // code to process the input file
                // declare a string variable to hold the current line
                String line = null;
                while (inputReader.ready()) {
                    //reading through each line
                    line = inputReader.readLine();
                    //outputting the text
                    System.out.println(line);
                }
            } catch (FileNotFoundException fileNotFound) {
                fileNotFound.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                try {
                    if (inputReader != null) {
                        inputReader.close();
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
