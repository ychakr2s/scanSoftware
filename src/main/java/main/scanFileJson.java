package main;

import Algorithm.scanAlgorithm;
import CreateJson.scanJson;
import CreateJson.scanJsonOutput;
import Graph.graph;
import ReadFile.readGraph;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 ** in this class i implement the Scan Algorithm. The output of the Implementation is a JSON Format written in Output file.
 */

public class scanFileJson {

    public static void main(String[] args) throws IOException {
        /*
         ** This step will check whether the File exist or not. If exists will delete it and create a new one.
         */
        String fileName = "D:\\Projects\\scanSoftware\\src\\main\\java\\Output_Files\\output.txt";
        try {
            if (Files.exists(Paths.get(fileName))) {
                Files.delete(Paths.get(fileName));
                Files.createFile(Paths.get(fileName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         ** This Step get the Graph-file which is intended to implement the Algorithm on it
         */
        String filename = "D:\\ABschlussArbeit\\Graphs\\DIMACS_all_ascii\\DIMACS_all_ascii\\johnson8-4-4.clq";

        readGraph rd = new readGraph();
        graph gr = rd.dimacsToGraph(filename);
        System.out.println("dazt man hna");

        scanAlgorithm sc = new scanAlgorithm(gr, 0.7f, 7f);
        System.out.println("dart scan");
        // Execute the Algorithm Scan
        scanJson out = sc.executeScanAlgorithm();

        /*
         ** Write the Output in the File as a JSON Format
         */
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

        scanJsonOutput jso = new scanJsonOutput(out);

        Gson gs = new Gson();
        String json = gs.toJson(jso);
        bw.write(json + System.getProperty("line.separator"));
        bw.write(" " + System.getProperty("line.separator"));

        bw.close();

        System.out.println("Sehen Sie die Datei in Output_Files Folder");
    }
}