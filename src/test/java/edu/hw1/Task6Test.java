package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @ParameterizedTest
    @DisplayName("countK - incorrect arguments")
    @ValueSource(ints = {-9999, 0, 1111, 2222, 5555, 10000, 901909})
    void countK_ShouldThrowExceptionForIncorrectArguments(int arg) {
        int result= Task6.countK(arg);

        assertThat(result).isEqualTo(-1);
    }

    @ParameterizedTest
    @DisplayName("countK - correct arguments")
    @CsvSource({
        "6174, 0",
        "-6621, 5",
        "6554, 4",
        "1234, 3",
        "3524, 3",
        "1000, 5"
    })
    void countK_ShouldWorkGivenCorrectArguments(int arg, int expected) {
        int actual = Task6.countK(arg);

        assertThat(actual).isEqualTo(expected);
    }
}
