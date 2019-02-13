package java112.labs1;

import java.io.*;
import java.util.*;

/**
* Creating the class for LabSeven
*
* @author jpabon
*/
public class LabSeven {
    List<String> list;

    public static void main(String[] args) {
        LabSeven lab = new LabSeven();

        //checking for a command line arguement
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line, "
            + "an output file name");
        } else {
            lab.run(args[0]);
        }
    }
    /**
    *
    * @param outputFile
    */
    public void run(String outputFile) {
        list = new ArrayList<String>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");

        writeListToOutputFile(outputFile);
    }

    public void writeListToOutputFile(String outputFile) {

        PrintWriter outputWriter = null;
        try {
            outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
            outputWriter.println(outputFile);
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
