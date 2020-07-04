package main;

import output.Context;
import output.consoleJsonOutputStrategy;
import output.consoleStringOutputStrategy;
import output.fileStringOutputStrategy;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String filename = "D:\\Projects\\scanSoftware\\src\\main\\java\\Input_Files\\testGraph.txt";
        Context loudParrot = new Context(new consoleStringOutputStrategy());
        loudParrot.execute(filename, 0.6f, 3);
    }
}
