package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("countDigits - zero")
    void countDigits_ShouldReturnOneForZero() {
        int number = 0;

        int numOfDigits = Task2.countDigits(number);

        assertThat(numOfDigits).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("countDigits - positive numbers")
    @CsvSource({
        "1, 1",
        "10, 2",
        "544, 3",
        "1000, 4",
        "4666, 4"
    })
    void countDigits_ShouldWorkGivenPositiveIntegers(int number, int numOfDigitsExpected) {
        int numOfDigits = Task2.countDigits(number);

        assertThat(numOfDigits).isEqualTo(numOfDigitsExpected);
    }

    @ParameterizedTest
    @DisplayName("countDigits - negative numbers")
    @CsvSource({
        "-1, 1",
        "-20, 2",
        "-999, 3",
        "-987654, 6"
    })
    void countDigits_ShouldWorkGivenNegativeIntegers(int number, int numOfDigitsExpected) {
        int numOfDigits = Task2.countDigits(number);

        assertThat(numOfDigits).isEqualTo(numOfDigitsExpected);
    }


}
