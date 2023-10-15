package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @ParameterizedTest
    @DisplayName("minutesToSeconds - null String")
    @NullSource
    void minutesToSeconds_ShouldReturnZeroForNullString(String videoLen) {
        int seconds = Task1.minutesToSeconds(videoLen);

        assertThat(seconds).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("minutesToSeconds - syntactically incorrect strings")
    @ValueSource(strings = {
        "", "mm:ss", "12345", "10::00",
        "00:1", "1:00", "00:001"
    })
    void minutesToSeconds_ShouldReturnNegativeForSyntacticallyIncorrectString(String videoLen) {
        int seconds = Task1.minutesToSeconds(videoLen);

        assertThat(seconds).isLessThan(0);
    }

    @ParameterizedTest
    @DisplayName("minutesToSeconds - too many seconds")
    @ValueSource(strings = {"00:60", "9999:99"})
    void minutesToSeconds_ShouldReturnNegativeForSecondsBiggerThan59(String videoLen) {
        int seconds = Task1.minutesToSeconds(videoLen);

        assertThat(seconds).isLessThan(0);
    }

    @ParameterizedTest
    @DisplayName("minutesToSeconds - various strings")
    @CsvSource({
        "00:00, 0",
        "01:00, 60",
        "13:56, 836",
        "999:59, 59999"
    })
    void minutesToSeconds_ShouldWorkGivenVariousStrings(String videoLen, int secondsExpected) {
        int seconds = Task1.minutesToSeconds(videoLen);

        assertThat(seconds).isEqualTo(secondsExpected);
    }
}
