package study.karel.test;

import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import study.karel.OptionTable;

public class TestOptionTable {
        private OptionTable optionTable;
        
        @Before
        public void setUp() {
                optionTable = new OptionTable("/width:100");
                
        }
        @Test
        public void parseOptionsTest() {
                assertEquals(100, optionTable.getIntOption("width"));
        }

        @Test
        public void parseOptionsTestWithUndefinedKey() {
                assertEquals(0, optionTable.getIntOption("height"));
        }
        
        @Test
        public void getBooleanOptionWithException() {
               try{
                       optionTable.getBooleanOption("width");
                       fail("Expected an IllegalArugmentException to be thrown");
               }catch (IllegalArgumentException illegalArgumentException){
                       assertEquals(illegalArgumentException.getMessage(), ("parseOptions: Illegal flag value"));
               }
        }
}
