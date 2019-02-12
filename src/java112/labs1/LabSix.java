package java112.labs1;

import java.io.*;
/**
* Class that will read input file and make a copy on another file.
* @author jpabon
*
*/
public class LabSix {
    public static void main(String[] args) {
        LabSix lab = new LabSix();

        // checking for two command line arguments
        // added the second parameter to run the method
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line, "
            + "an input file name and an output file name");
        } else {
            lab.run(args[0], args[1]);
        }
    }
    /**
    *
    *
    */
    public void run(String inputPath, String outputFile) {
        BufferedReader input = null;
        PrintWriter output = null;
        try {
            input = new BufferedReader(new FileReader(inputPath));
            output = new PrintWriter(new BufferedWriter(
                    new FileWriter(outputFile)));
            while (input.ready()) {
                output.println(input.readLine());
            }
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
