package java112.analyzer;

import java.io.*;
import java.util.*;

/**
*
* @author jpabon
*
*/
public class FileAnalysis {

    private static final int VALID_ARGUMENT_NUMBER_COUNT = 1;
    private String summaryAnalyzer;
    private String distinctAnalyzer;

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