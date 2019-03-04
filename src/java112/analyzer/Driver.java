package java112.analyzer;


/**
* @author jpabon
* @param argument this is where the analyze method is being called
*/

public class Driver {
    public static void main(String[] arguments) {
        FileAnalysis startFile = new FileAnalysis();
        startFile.analyze(arguments);
    }
}
