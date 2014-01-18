package com.awscherb.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * LineReader reads a text file one line at a time
 * @author Alex Scherb
 * @version 1/18/14
 */
public final class LineReader implements Iterator<String>, Iterable<String> {

    /** The input file */
    private static String input;
    /** The input reader */
    private BufferedReader br;

    /**
     * Private constructor; use public static factory method for creation
     * @param file <code>String</code> location of the file
     * @throws FileNotFoundException if the file cannot be found
     */
    private LineReader(String file) {
        input = file;
        try {
            br = new BufferedReader(new FileReader(input));
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
     * Return this; LineReader objects implement <code>Iterator</code> 
     * @return this
     */ 
    public Iterator<String> iterator() { return this; }

    /**
     * Check if this has a next
     * @return the Boolean result
     */
    public boolean hasNext() { 
        try {
            return br.ready();
        } catch (IOException e) {       
            return false;
        } 
    }

    /**
     * Return the next element, if it exists, else returns null
     * @return The next element
     */
    public String next() {
        try {
            return br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    /** Remove the first element */
    public void remove() { 
        try {
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
