package java112.labs1;

/**
*
* @author jpabon
*
*/
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
    * @param String The outputFile
    *
    */
    public void run(String outputFile)  {
        set = new TreeSet<String>();

        set.add("one");
        set.add("one");
        set.add("five");
        set.add("two");
        set.add("four");
        set.add("two");
        set.add("three");
        set.add("three");
        set.add("four");
        set.add("three");

        writeSetToOutputFile(outputFile);
    }
}
