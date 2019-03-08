package java112.analyzer;

/**
* The main class creates the object of the fileAnalysis class and then
* passes an argument to the analyze method.
* @author jpabon
*
*/

public class Driver {
    /**
    * @param arguments this is the command line arguments
    */
    public static void main(String[] arguments) {
        FileAnalysis startFile = new FileAnalysis();
        startFile.analyze(arguments);
    }
}
