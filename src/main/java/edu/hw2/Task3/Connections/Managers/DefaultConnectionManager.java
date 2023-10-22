package edu.hw2.Task3.Connections.Managers;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        Random rng = new Random();
        boolean faulty = rng.nextBoolean();
        if (faulty) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
