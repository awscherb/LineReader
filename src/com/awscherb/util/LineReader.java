package com.awscherb.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LineReader reads a text file one line at a time
 * @author Alex Scherb
 * @version 1/17/14
 */
public final class LineReader implements Iterator<String>, Iterable<String> {

    /** The input file */
    private static String input;
    /** The input file as an <code>ArrayDeque</code>, each line is a string */
    private ArrayDeque<String> lines;
    /** The input reader */
    private BufferedReader br;

    /**
     * Private constructor; use public static factory method for creation
     * @param file <code>String</code> location of the file
     * @throws FileNotFoundException if the file cannot be found
     */
    private LineReader(String file) {
        lines = new ArrayDeque<String>();
        input = file;
            try {
                br = new BufferedReader(new FileReader(input));
                init();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }

    /**
     * Public static factory method, invokes private constructor
     * @param s the <code>String</code> file location
     * @return the new <code>LineReader</code> object
     */
    public static LineReader factory(String s) {
        return new LineReader(s);
    } 

    /**
     * Add each line of the input file to our <code>ArrayDeque</code>
     */
    private void init() {
        try {
            String line;
            while ((line = br.readLine()) != null) { // This is the slowest part
                lines.push(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return this; LineReader objects implement <code>Iterator</code> 
     * @return this
     */
    public Iterator<String> iterator() { 
        return this; // This is an iterator
    }

    /**
     * Check if this has a next
     * @return the Boolean result
     */
    public boolean hasNext() {
        return (!lines.isEmpty());
        // Test
    }

    /**
     * Return the next element, if it exists, else throw an exception
     * @return The next element
     * @throws NoSuchElementException if we are at the end
     */
    public String next() {
        if (hasNext()) {
            return lines.pop();
        }
        else { throw new NoSuchElementException(); }
    }

    /** Remove the first element */
    public void remove() { 
        lines.pop(); 
    }
}
