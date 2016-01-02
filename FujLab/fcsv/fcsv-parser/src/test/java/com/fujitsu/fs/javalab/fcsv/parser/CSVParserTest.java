package com.fujitsu.fs.javalab.fcsv.parser;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CSVParserTest {

    @Test
    public void testParseLineBasic() {
        assertArrayEquals(new String[]{"1997", "Ford", "E350"},
                CSVParser.parseLine("1997,Ford,E350"));
    }

    @Test
    public void testParseLineSpaces() {
        assertArrayEquals(new String[]{"1997", "Ford", "E350", "Super", "luxurious truck"},
                CSVParser.parseLine("1997,Ford,E350,Super,luxurious truck"));
    }

    @Test
    public void testParseLineQuotes() {
        assertArrayEquals(new String[]{"1997", "", "E350"},
                CSVParser.parseLine("\"1997\",\"\",E350"));
    }

    @Test
    public void testParseLineWithCommas() {
        assertArrayEquals(new String[]{"1997", "Ford", "E350", "Super", "luxurious, truck"},
                CSVParser.parseLine("1997,Ford,E350,Super,\"luxurious, truck\""));
    }

    //Homework

    @Test
    public void testParseLineWithDouble(){
        assertArrayEquals(new String[]{"1997", "Ford", "E350", "ac, abs, moon", "3000.00"},
                CSVParser.parseLine("1997,Ford,E350,\"ac, abs, moon\",3000.00"));
    }

    @Test
    public void testParseLineWithEmptyQuotes(){
        assertArrayEquals(new String[]{"1999", "Chevy", "Venture \"Extended Edition\"","","4900.00"},
                CSVParser.parseLine("1999,Chevy,\"Venture \"\"Extended Edition\"\"\",\"\",4900.00"));
    }

    @Test
    public void testParseLineEmpySpaceBetweenDelimiters(){
        assertArrayEquals(new String[]{"1999","Chevy","Venture \"Extended Edition, Very Large\"","","5000.00"},
                CSVParser.parseLine("1999,Chevy,\"Venture \"\"Extended Edition, Very Large\"\"\",,5000.00"));
    }


}
