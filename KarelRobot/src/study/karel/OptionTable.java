package study.karel;

import java.util.HashMap;
import java.util.StringTokenizer;

public class OptionTable {
    
    private HashMap<String, String> table;
    
    public OptionTable() {
        table = new HashMap<String, String>();
    }
    
    public OptionTable(String options) {
        this();
        parseOptions(options);
    }

    private void parseOptions(String options) {
        parseOptions(options, table);
    }

    private void parseOptions(String options, HashMap<String, String> table2) {
        // TODO Auto-generated method stub
        
    }
}
