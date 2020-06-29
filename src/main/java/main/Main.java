package main;

import output.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename = "D:\\Projects\\jalal_Software\\ScanSoftware\\src\\main\\java\\Input_Files\\testGraph.txt";

        Context loudParrot = new Context(new fileStringOutputStrategy());

        loudParrot.execute(filename, 0.6f, 3);
    }
}
