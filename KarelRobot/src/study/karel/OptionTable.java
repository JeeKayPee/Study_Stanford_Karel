package study.karel;

import java.util.HashMap;
import java.util.StringTokenizer;

import org.omg.CORBA.INITIALIZE;

public class OptionTable {
        private static final int INITIAL_STATE = 0;
        private static final int KEY_SEEN = 1;
        private static final int COLON_SEEN = 2;
        private static final int VALUE_SEEN = 3;
        
        private HashMap<String, String> table;

        public OptionTable() {
                table = new HashMap<String, String>();
        }

        public OptionTable(String options) {
                this();
                parseOptions(options);
        }

        public void parseOptions(String options) {
                parseOptions(options, table);
        }

        private void parseOptions(String options, HashMap<String, String> map) {
                StringTokenizer scanner = new StringTokenizer(options + "/", "/:", true);
                String key = null;
                String value = null;
                int state = INITIAL_STATE;
                
                while(scanner.hasMoreTokens()){
                        String token = scanner.nextToken();
                        switch(state){
                        case INITIAL_STATE:
                                if (! token.equals("/")) {
                                        key = token.toLowerCase();
                                        value = "";
                                        state = KEY_SEEN;
                                }
                                break;
                        case KEY_SEEN:
                                if (token.equals("/")){
                                        map.put(key, value);
                                        state = INITIAL_STATE;
                                }else if(token.equals(":")){
                                        state = COLON_SEEN;
                                }
                                break;
                        case COLON_SEEN:
                                value = token;
                                state = VALUE_SEEN;
                                break;
                        case VALUE_SEEN:
                                if(token.equals("/")){
                                        map.put(key, value);
                                        state = INITIAL_STATE;
                                }else {
                                        String msg = "parseOptions: Illegal option string";
                                        throw new IllegalArgumentException(msg);
                                }
                                break;
                        }
                }
        }
        
        public boolean isSpecified(String key) {
                return table.containsKey(key);
        }
        
        public String getOption(String key) {
                return getOption(key, null);
        }
        
        public String getOption(String key, String defaultValue){
                String value = table.get(key.toLowerCase());
                return(value == null || value.equals("")) ? defaultValue : value;
        }
        
        public int getIntOption(String key){
                return getIntOption(key, 0);
        }
        
        public int  getIntOption(String key, int defaultValue){
                String value = getOption(key.toLowerCase());
                return(value == null || value.equals("")) ? defaultValue : Integer.decode(value).intValue();
        }
        
        public double getDoubleOption(String key) {
                return getDoubleOption(key, 0.0);
        }
        
        public double getDoubleOption(String key, double defaultValue) {
                String value = getOption(key.toLowerCase());
                return (value == null || value.equals("")) ? defaultValue : Double.valueOf(value).doubleValue();
        }
        
        public boolean getBooleanOption(String key){
                return getBooleanOption(key, false);
        }
        
        public boolean getBooleanOption(String key, boolean defaultValue){
                String value = table.get(key.toLowerCase());
                if(value == null)
                        return defaultValue;
                value = value.toLowerCase();
                if (value.equals("") || value.equals("true") || value.equals("t") || value.equals("on") ){
                        return true;
                }else if (value.equals("false") || value.equals("f") || value.equals("off") ) {
                        return false;
                }
                throw new IllegalArgumentException("parseOptions: Illegal flag value");
                
        }
}
