package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @ParameterizedTest
    @DisplayName("fixString - null string")
    @NullSource
    void fixString_ShouldThrowExceptionForNullInputs(String input) {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String result = Task4.fixString(input);
        });

        Assertions.assertEquals("The string must be non-null to be corrected", thrown.getMessage());
    }

    @ParameterizedTest
    @DisplayName("fixString - empty string")
    @EmptySource
    void fixString_ShouldDoNothingForEmptyString(String input) {
        String actualString = Task4.fixString(input);

        assertThat(actualString).isEqualTo(input);
    }

    @ParameterizedTest
    @DisplayName("fixString - even length strings")
    @CsvSource({
        "123456, 214365",
        "hTsii  s aimex dpus rtni.g, This is a mixed up string."
    })
    void fixString_ShouldWorkGivenEvenStrings(String mixedUpString, String expectedString) {
        String actualString = Task4.fixString(mixedUpString);

        assertThat(actualString).isEqualTo(expectedString);
    }

    @ParameterizedTest
    @DisplayName("fixString - odd length strings")
    @CsvSource({
        "1, 1",
        "12345, 21435",
        ")abc pk _, a)cbp  k_"
    })
    void fixString_ShouldWorkGivenOddStrings(String mixedUpString, String expectedString) {
        String actualString = Task4.fixString(mixedUpString);

        assertThat(actualString).isEqualTo(expectedString);
    }
}
