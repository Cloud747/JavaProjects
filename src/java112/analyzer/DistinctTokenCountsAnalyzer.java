package java112.analyzer;

import java.io.*;
import java.util.*;


/**
* This new analyzer will count the number of unique tokens
* @author jpabon
*
*/
public class DistinctTokenCountAnalyzer {
    private Properties properties;

    private Map<String, Integer> distinctTokenCounts;

    public Map<String, Integer> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }
}
