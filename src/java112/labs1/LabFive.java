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

        //checking if there are two command line arguments
        if (args.length != 2) {
            System.out.println("Please enter two arguments on the command line, a file name and a message");
        } else {
            lab.run(args[0], args[1]);
        }
    }
    public void run(String inputName, String message) {

    }
}
