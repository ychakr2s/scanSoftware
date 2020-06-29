package output;

import Algorithm.scanAlgorithm;
import CreateJson.scanJson;
import CreateJson.scanJsonOutput;
import Graph.graph;
import ReadFile.readGraph;
import abstractOutput.OutputStrategy;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 ** in this class i implement the Scan Algorithm. The output of the Implementation is a JSON Format written in OutputStrategy file.
 */

public class fileJsonOutputStrategy implements OutputStrategy {

    @Override
    public void executeOutput(String filename, float eps, float mu) throws IOException {
        /*
         ** This step will check whether the File exist or not. If exists will delete it and create a new one.
         */
        String outputFile = "D:\\Projects\\scanSoftware\\src\\main\\java\\Output_Files\\output.txt";
        try {
            if (Files.exists(Paths.get(outputFile))) {
                Files.delete(Paths.get(outputFile));
                Files.createFile(Paths.get(outputFile));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         ** This Step get the Graph-file which is intended to implement the Algorithm on it
         */
//        String filename = "D:\\ABschlussArbeit\\Graphs\\DIMACS_all_ascii\\DIMACS_all_ascii\\johnson8-4-4.clq";

        readGraph rd = new readGraph();

        graph gr = rd.factoryGraph(filename);

        scanAlgorithm sc = new scanAlgorithm(gr, eps, mu);
        // Execute the Algorithm Scan
        scanJson out = sc.executeScanAlgorithm();

        /*
         ** Write the OutputStrategy in the File as a JSON Format
         */
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));

        scanJsonOutput jso = new scanJsonOutput(out);

        Gson gs = new Gson();
        String json = gs.toJson(jso);
        bw.write(json + System.getProperty("line.separator"));
        bw.write(" " + System.getProperty("line.separator"));

        bw.close();

        System.out.println("Sehen Sie die Datei in Output_Files Folder");
    }
}