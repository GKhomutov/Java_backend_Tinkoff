package edu.hw2.Task3;

import edu.hw2.Task3.Connections.Exeptions.ConnectionException;
import edu.hw2.Task3.Connections.Managers.DefaultConnectionManager;
import edu.hw2.Task3.Connections.Managers.FaultyConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    @DisplayName("tryExecute - faulty connection manager")
    void tryExecute_FaultyConnectionManager() {
        var manager = new FaultyConnectionManager();
        var executor = new PopularCommandExecutor(manager, 1);

        int failures = 0;
        for (int i = 0; i < 10_000; ++i) {
            try {
                executor.updatePackages();
            } catch (ConnectionException e) {
                ++failures;
            }
        }
        assertThat(failures).isGreaterThan(3_000);
    }

    @Test
    @DisplayName("tryExecute - default connection manager")
    void tryExecute_DefaultConnectionManager() {
        var manager = new DefaultConnectionManager();
        var executor = new PopularCommandExecutor(manager, 1);

        int failures = 0;
        for (int i = 0; i < 10_000; ++i) {
            try {
                executor.updatePackages();
            } catch (ConnectionException e) {
                ++failures;
            }
        }
        assertThat(failures).isLessThan(3_000);
    }
}
