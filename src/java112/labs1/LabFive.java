package java112.labs1;

import java.io.*;

/**
* Building the class for LabFive
* @author jpabon
*
*/
public class LabFive {
    /**
    *
    * @param args command line arguments
    */
    public static void main(String[] args) {
        LabFive lab = new LabFive();

        // checking if there are two command line arguments
        // added the second parameter to the run method
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line, a file name and a message");
        } else {
            lab.run(args[0], args[1]);
        }
    }
    /**
    * Creating the run method that will pass in the inputName and Message
    * @param inputName
    * @param message
    */
    public void run(String inputName, String message) {
        PrintWriter outputWriter = null;
        try {
            outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(inputName)));
            outputWriter.println(message);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (outputWriter != null) {
                outputWriter.close();
            }
        }
    }
}
