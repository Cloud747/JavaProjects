package java112.labs1;


public class LabEight {
    Set<String> set;

    public static void main(String[] args) {
        LabEight lab = new LabEight();

        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line, "
            + "an input file name and an output file name");
        } else {
            lab.run(args[0]);
        }
    }
    /**
    *
    *
    */
    public void run(String outputFile)  {

    }
}
