package com.awscherb.util;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Examples for LineReader
 * @author Alex Scherb
 * @version 1/17/14
 */
public class Examples {
    
    // Stuff
    static ArrayList<String> ar = new ArrayList<String>();
    static String val = "line";

    // IO
    static String file = "line1000000.txt";
    static String out = "line1000000.txt";
    static LineReader lr;

    // Start, end time
    static long s;
    static long e;

    // Switches
    static boolean OUT = false;
    static boolean ARTEST = false;
    static boolean LRTEST = true;

    // Size for output loop
    static final int size = 1000000;

    static void out() throws IOException {
        s = System.currentTimeMillis();
        BufferedWriter wri = new BufferedWriter(
                new FileWriter(out, true));
        try {
            for (int i = 0; i < size; i = i + 1) {
                wri.write("line\n"); // Write the line
            }
        }         
        catch (IOException e) {
            System.out.println("IOException");
        }
        finally {
            wri.close(); 
            e = System.currentTimeMillis();
            System.out.println(e - s);
        }
    }

    static void initAR() {
        for (int i = 0; i < size; i = i + 1) {
            ar.add(val);
        }
    }

    public static void main(String[] arg) {
        if (OUT) {
            try { out(); } catch (IOException e1) {  }
        }

        if (ARTEST) { // For comparing a LineReader to an ArrayList
            s = System.currentTimeMillis();
            initAR();
            e = System.currentTimeMillis();
            System.out.println("ArrayList Initialization: " + (e - s));

            s = System.currentTimeMillis();
            Iterator<String> arit = ar.iterator();
            e = System.currentTimeMillis();
            System.out.println("ArrayList getting iterator: " + (e - s));

            s = System.currentTimeMillis();
            while(arit.hasNext()) { arit.next(); }
            e = System.currentTimeMillis();
            System.out.println("ArrayList Iteration: " + (e - s));
        }

        if (LRTEST) { // LineReader tests
            s = System.currentTimeMillis();
            lr = LineReader.factory(file);
            e = System.currentTimeMillis();
            System.out.println("LineReader Initialization: " + (e - s));

            s = System.currentTimeMillis();
            while(lr.hasNext()) { lr.next(); }
            e = System.currentTimeMillis();
            System.out.println("LineReader Iteration: " + (e - s));
        }
    }

}
