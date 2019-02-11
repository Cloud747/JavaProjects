package java112.labs1;

import java.io.*;
/**
* Class that will check for
* @author jpabon
*
*/
public class LabSix {
    public static void main(String[] args) {
        LabSix lab = new LabSix();

        // checking for two command line arguments
        // added the second parameter to run the method
        if (args.length != 2) {
            System.out.println("please enter two arguments on the command line, "
            + " an input file name and an output file name");
        } else {
            lab.run(args[0], args[1]);
        }
    }

}
