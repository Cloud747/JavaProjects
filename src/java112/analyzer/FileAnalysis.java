package java112.analyzer;
/**
*
* @author jpabon
*
*/
public class FileAnalysis {

    private static final int VALID_ARGUMENT_NUMBER_COUNT = 1;
    private SummaryAnalyzer summaryAnalyzer;
    private DistinctAnalyzer distinctAnalyzer;

    /**
    *
    * @param arguments
    *
    */
    public void analyze(String[] arguments){
        if (arguments.length != VALID_ARGUMENT_NUMBER_COUNT) {
            System.out.println("Please enter the right input");
            return;
        }

    }
}
