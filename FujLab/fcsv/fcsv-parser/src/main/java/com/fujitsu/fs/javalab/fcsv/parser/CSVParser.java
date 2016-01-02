package com.fujitsu.fs.javalab.fcsv.parser;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j;

public class CSVParser implements Closeable {

    Logger log = LoggerFactor.getLogger(CSVParser.class);
    public static final char DELIMITER = ',';
    public static final char ESCAPE_CHAR = '"';

    private BufferedReader in;

    public CSVParser(File file) throws IOException {
        this(file, Charset.defaultCharset());
    }

    public CSVParser(File file, Charset cs) throws IOException {
        log.info("Creating new CSVParser for line {} using charset {}",file.getPath(), cs.displayName());
        in = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), cs));
    }

    public CSVParser(Reader in) {
        if (in instanceof BufferedReader) {
            this.in = (BufferedReader) in;
        } else {
            this.in = new BufferedReader(in);
        }
    }

    public String[] nextRow() throws IOException {
        String line = in.readLine();
        log.trace("Parsing line '{}'",line);
        String[] parsed = parseLine(line);
        log.trace("Parsed values '{}'", Arrays.toString(parsed));
        return line != null ? parsed : null;
    }

    protected static String[] parseLine(String line) {
        List<String> values = new ArrayList<>();
        StringBuilder value = new StringBuilder();
        boolean escaped = false;
        for (char symbol : line.toCharArray()) {
            if (symbol == DELIMITER && !escaped) {
                values.add(value.toString());
                value = new StringBuilder();
            } else if (symbol == ESCAPE_CHAR) {
                escaped = !escaped;
                if (escaped && value.length() != 0) {
                    value.append(symbol);
                }
            } else {
                value.append(symbol);
            }
        }
        values.add(value.toString());
        return values.toArray(new String[values.size()]);
    }

    @Override
    public void close() throws IOException {
        if (in != null) {
            in.close();
        }
    }
}
