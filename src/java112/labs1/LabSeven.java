package java112.labs1;

import java.io.*;

/**
* Creating the class for LabSeven
*
* @author jpabon
*/
public class LabSeven {

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
}
