package java112.analyzer;



import java.io.*;
import java.util.*;
import java112.utilities.*;


public class WordCounter implements PropertiesLoader {
    private static final int VALID_ARGUMENT_COUNT = 3;

    //private WordCollection wordCollection;
    //private Report report;
    private List<Parser> parsers;
    /**
    * This method will test to ensure the number of arguments has been entered correctly by the user.
    * @param arguments This argument should include more than one input number to the command line.
    */
    public void analyze(String[] arguments) {
        if (arguments.length != VALID_ARGUMENT_COUNT) {
            System.out.println("Please enter more than one input number to the command line");
            return;
        }
        //wordCollection = new WordCollection();
        //report = new Report();
        //report.initialize(arguments[0]);
        //this.openInputFile(arguments[0], Integer.parseInt(arguments[1]));
        //this.createOutputFile();
        Properties properties = this.loadProperties(arguments[2]);
        this.createParsers(properties);
        this.initializeParsers(arguments[0]);
    }
    //
    private void createParsers(Properties properties) {
        //parsers = new List<Parser>();
        parsers.add(new Report(properties));
        parsers.add(new WordCollection(properties));
    }
    private void initializeParsers(String inputPath) {
        for (Parser parser : parsers) {
            parser.initialize(inputPath);
        }
    }

    /**
    * The method will be call the persist methods for the report and word collection classes
    */
    public void createOutputFile() {

        //report.persist("report.txt");
        //wordCollection.persist("words.txt");
        for (Parser parser : parsers) {
            parser.persist();
        }
    }
    /**
    * Opens the file and loops through each word.
    * @param filePath This is the filepath
    * @param count This is the interval for the dots.
    */
    private void openInputFile(String filePath, int count) {

        try (BufferedReader inputReader = new BufferedReader(new FileReader(filePath));
             PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("report.txt")))){
             //While loop that will go through all the lines of the input file
             String line = null;
             while (inputReader.ready()) {
                line = inputReader.readLine();
                String[] words = line.split("\\W");
                //For loop that will
                for (int i = 0; i < words.length; i++) {
                  //report.nextWord(words[i]);
                  //wordCollection.nextWord(words[i]);
                  //report.onProgress(count, ".");
                  for (Parser parser : parsers) {
                      parser.nextWord(words[i]);
                  }
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
                 fileNotFoundException.printStackTrace();
        } catch (IOException inputOutputException) {
                 inputOutputException.printStackTrace();
        } catch (Exception exception) {
                 exception.printStackTrace();
        }
    }
}
