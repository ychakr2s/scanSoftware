package output;

import abstractOutput.OutputStrategy;

import java.io.IOException;

public class Context {


    private final OutputStrategy outputStrategy;

    public Context(OutputStrategy parrotStrategy) {
        this.outputStrategy = parrotStrategy;
    }

    public void execute(String text, float eps, float mu) throws IOException {
        outputStrategy.executeOutput(text, eps, mu);
    }


}
