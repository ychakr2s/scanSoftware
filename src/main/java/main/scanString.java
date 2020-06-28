package main;

import Algorithm.scanAlgorithm;
import Graph.graph;
import ReadFile.readGraph;

/*
 ** in this class i implement the Scan Algorithm.
 * The output of the Implementation is a String Format displayed on the console
 */
public class scanString {
    public static void main(String[] args) {
        /*
         ** This Step get the Graph-file which is intended to implement the Algorithm on it
         */
        String filename = "D:\\ABschlussArbeit\\Graphs\\DIMACS_all_ascii\\DIMACS_all_ascii\\C125.9.clq";

        readGraph rd = new readGraph();
        graph gr = rd.selfGenerated(filename);

        // print the Graph
        System.out.println(gr.toString());

        scanAlgorithm sc = new scanAlgorithm(gr, 0.6f, 3f);

        // Execute the Algorithm Scan
        sc.executeScanAlgorithm();

        System.out.println(sc.toString());
    }
}