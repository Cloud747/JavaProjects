package java112.analyzer;


/**
*
* @author jpabon
*
*/

public class Driver {
    public static void main(String[] arguments) {
        FileAnalysis startFile = new FileAnalysis();
        startFile.analyze(arguments);
    }
}
