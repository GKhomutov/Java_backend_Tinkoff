package edu.hw2.Task3;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.Exeptions.ConnectionException;
import edu.hw2.Task3.Connections.Managers.ConnectionManager;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxExecutionAttempts) {
        this.manager = manager;
        this.maxAttempts = maxExecutionAttempts;
    }

    public void updatePackages() throws ConnectionException {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) throws ConnectionException {
        int cnt = 0;
        while (true) {
            ++cnt;
            try (Connection connection = manager.getConnection();) {
                connection.execute(command);
                return;
            } catch (ConnectionException e) {
                if (cnt == maxAttempts) {
                    throw new ConnectionException(
                        "PopularCommandExecutor could not execute the command: " + "'" + command + "'",
                        e
                    );
                }
            } catch (Exception e) {
                /* empty */
            }
        }
    }
}
