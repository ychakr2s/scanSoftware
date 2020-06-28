package main;

import Algorithm.scanAlgorithm;
import ReadFile.readGraph;
import com.google.gson.Gson;
import Graph.graph;
import CreateJson.scanJsonOutput;

public class scanJson {
    public static void main(String[] args) {
        /*
         ** This Step get the Graph-file which is intended to implement the Algorithm on it
         */
        String filename = "D:\\Projects\\jalal_Software\\ScanSoftware\\src\\main\\java\\Input_Files\\testGraph.txt";

        readGraph rd = new readGraph();
        graph gr = rd.selfGenerated(filename);
        System.out.println(gr.toString());

        scanAlgorithm sc = new scanAlgorithm(gr, 0.6f, 3f);

        scanJsonOutput jso = new scanJsonOutput(sc.executeScanAlgorithm());

        Gson gs = new Gson();
        String json = gs.toJson(jso);

        System.out.println(json);
    }
}
