package output;

import Algorithm.scanAlgorithm;
import CreateJson.scanJsonOutput;
import Graph.graph;
import ReadFile.readGraph;
import abstractOutput.OutputStrategy;
import com.google.gson.Gson;

public class consoleJsonOutputStrategy implements OutputStrategy {

    @Override
    public void executeOutput(String filename, float eps, float mu) {
        /*
         ** This Step get the Graph-file which is intended to implement the Algorithm on it
         */
//        String filename = "D:\\Projects\\jalal_Software\\ScanSoftware\\src\\main\\java\\Input_Files\\testGraph.txt";

        readGraph rd = new readGraph();
        graph gr = rd.factoryGraph(filename);
//        System.out.println(gr.toString());

        scanAlgorithm sc = new scanAlgorithm(gr, eps, mu);

        scanJsonOutput jso = new scanJsonOutput(sc.executeScanAlgorithm());

        Gson gs = new Gson();
        String json = gs.toJson(jso);

        System.out.println(json);

    }
}
