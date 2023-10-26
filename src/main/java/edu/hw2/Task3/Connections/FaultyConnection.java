package edu.hw2.Task3.Connections;

import edu.hw2.Task3.Connections.Exeptions.ConnectionException;
import java.util.Random;

public class FaultyConnection implements Connection {
    public void execute(String command) throws ConnectionException {
        Random rng = new Random();
        boolean success = rng.nextBoolean();
        if (!success) {
            throw new ConnectionException("FaultyConnection execution failure");
        }
    }

    @Override
    public void close() throws Exception {
    }
}
