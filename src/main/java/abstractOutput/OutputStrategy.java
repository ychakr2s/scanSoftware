package abstractOutput;

import java.io.IOException;

public interface OutputStrategy {

    public void executeOutput(String text, float eps, float mu) throws IOException;
}
