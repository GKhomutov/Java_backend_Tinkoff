package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @ParameterizedTest
    @DisplayName("isPalindromeDescendant")
    @CsvSource({
        "11211230, true",
        "0, false",
        "13001120, true",
        "23336014, true",
        "1122, false",
        "11, true",
        "633, true"
    })
    void isPalindromeDescendant_ShouldWorkGivenVariousIntegers(int number, boolean expectedResult) {
        boolean actualResult = Task5.isPalindromeDescendant(number);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
