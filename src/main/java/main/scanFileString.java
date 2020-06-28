package main;

import Algorithm.scanAlgorithm;
import Graph.graph;
import ReadFile.readGraph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 ** in this class i implement the Scan Algorithm.
 * The output of the Implementation is a String Format written in Output file.
 */
public class scanFileString {
    public static void main(String[] args) throws IOException {
        /*
         ** This step will check whether the File exist or not.
         * If exists will delete it and create a new one.
         */
        String fileName = "D:\\Projects\\jalal_Software\\ScanSoftware\\src\\main\\java\\Output_Files\\output.txt";
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
        String filename = "D:\\ABschlussArbeit\\Graphs\\DIMACS_all_ascii\\DIMACS_all_ascii\\hamming6-4.clq";

        readGraph rd = new readGraph();
        graph gr = rd.dimacsToGraph(filename);

        scanAlgorithm sc = new scanAlgorithm(gr, 0.6f, 3f);

        // Execute the Algorithm Scan
        sc.executeScanAlgorithm();

        /*
         ** Write the Output in the File as a String Format
         */
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

        String output = sc.toString();
        bw.write(output + System.getProperty("line.separator"));
        bw.close();

        System.out.println("Sehen Sie die Datei in Output_Files Folder");
    }
}
