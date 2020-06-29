package output;

import Algorithm.scanAlgorithm;
import Graph.graph;
import ReadFile.readGraph;
import abstractOutput.OutputStrategy;

/*
 ** in this class i implement the Scan Algorithm.
 * The output of the Implementation is a String Format displayed on the console
 */
public class consoleStringOutputStrategy implements OutputStrategy {

    @Override
    public void executeOutput(String filename, float eps, float mu) {
        /*
         ** This Step get the Graph-file which is intended to implement the Algorithm on it
         */
//        String filename = "D:\\Projects\\scanSoftware\\src\\main\\java\\Input_Files\\testGraph.txt";

        /*
         ** This Step products a Graph (FACTORY PATTERN)
         */
        readGraph rd = new readGraph();

        graph gr = rd.factoryGraph(filename);

        // print the Graph
//        System.out.println(gr.toString());

        scanAlgorithm sc = new scanAlgorithm(gr, eps, mu);

        // Execute the Algorithm Scan
        sc.executeScanAlgorithm();

        System.out.println(sc.toString());
    }
}