package java112.labs1;

import java.io.*;

/**
* Working on Lab four class
* @author Jpabon
*/
public class LabFour {
    /**
    * Using BufferedReader to read a file line by line
    * and output each line
    * @param args command line arguments
    **/
    public static void main(String[] args) {
        LabFour lab = new LabFour();

        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line");
        } else {
            lab.run(args[0]);
        }
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
