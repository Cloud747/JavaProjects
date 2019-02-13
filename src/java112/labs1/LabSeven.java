package java112.labs1;

import java.io.*;
import java.util.*;

/**
* Creating the class for LabSeven
*
* @author jpabon
*/
public class LabSeven {

    public static void main(String[] args) {
        LabSeven lab = new LabSeven();
        List<String> list = new ArrayList<String>();

        list.add()

        //checking for a command line arguement
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line, "
            + "an output file name");
        } else {
            lab.run(args[0]);
        }
    }
    public void run(String outputFile) {
        
    }

}
