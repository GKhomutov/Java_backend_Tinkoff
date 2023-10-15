package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    @DisplayName("rotateRight - non-positive number")
    void rotateRight_ShouldThrowExceptionForNonPositiveNumber() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int result = Task7.rotateRight(-1, 1);
        });

        Assertions.assertEquals("The number must be positive for rotation", thrown.getMessage());
    }

    @ParameterizedTest
    @DisplayName("rotateRight - correct arguments")
    @CsvSource({
        "8, 1, 4"
    })
    void rotateRight_ShouldWorkGivenVariousArguments(int number, int shift, int expected) {
        int actual = Task7.rotateRight(number, shift);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("rotateLeft - non-positive number")
    void rotateLeft_ShouldThrowExceptionForNonPositiveNumber() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int result = Task7.rotateLeft(-1, 1);
        });

        Assertions.assertEquals("The number must be positive for rotation", thrown.getMessage());
    }


    @ParameterizedTest
    @DisplayName("rotateLeft - correct arguments")
    @CsvSource({
        "16, 1, 1",
        "17, 2, 6"
    })
    void rotateLeft_ShouldWorkGivenVariousArguments(int number, int shift, int expected) {
        int actual = Task7.rotateLeft(number, shift);

        assertThat(actual).isEqualTo(expected);
    }
}
