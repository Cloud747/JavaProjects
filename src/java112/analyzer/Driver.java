package java112.analyzer;

/**
* @author jpabon
* The main class creates the object of the fileAnalysis class and then
* passes an argument to the analyze method.
* @param argument command line of arguments
*/

public class Driver {
    public static void main(String[] arguments) {
        FileAnalysis startFile = new FileAnalysis();
        startFile.analyze(arguments);
    }
}
