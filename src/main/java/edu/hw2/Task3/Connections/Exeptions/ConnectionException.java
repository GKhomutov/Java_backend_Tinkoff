package edu.hw2.Task3.Connections.Exeptions;

public class ConnectionException extends RuntimeException {
    private static final String NAME = "Connection exception";

    public ConnectionException(String message) {
        super(NAME + ": " + message);
    }

    public ConnectionException(String message, Exception cause) {
        super(NAME + ": " + message, cause);
    }
}

