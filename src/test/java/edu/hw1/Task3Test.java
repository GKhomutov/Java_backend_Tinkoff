package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @ParameterizedTest
    @DisplayName("isNestable - null and empty array(s)")
    @MethodSource
    void isNestable_ShouldRWorkGivenNullAndEmpty(int[] numbers1, int[] numbers2, boolean expected) {
        boolean actual = Task3.isNestable(numbers1, numbers2);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> isNestable_ShouldRWorkGivenNullAndEmpty() {
        return Stream.of(
            // null
            Arguments.of(null, null, false),
            Arguments.of(null, new int[] {1, 2, 3}, false),
            Arguments.of(new int[] {1, 2, 3}, null, false),

            // empty
            Arguments.of(new int[0], new int[0], false),
            Arguments.of(new int[] {1}, new int[0], false),
            Arguments.of(new int[0], new int[] {1}, true),

            // null and empty
            Arguments.of(null, new int[0], false),
            Arguments.of(new int[0], null, false)
        );
    }

    @ParameterizedTest
    @DisplayName("isNestable - non-nested, both arrays filled")
    @MethodSource
    void isNestable_ShouldRWorkGivenNonNestedFilled(int[] numbers1, int[] numbers2) {
        boolean actual = Task3.isNestable(numbers1, numbers2);

        assertThat(actual).isEqualTo(false);
    }

    private static Stream<Arguments> isNestable_ShouldRWorkGivenNonNestedFilled() {
        return Stream.of(
            Arguments.of(new int[] {-2, -1}, new int[] {1, 2}),
            Arguments.of(new int[] {1, 2}, new int[] {4, 2}),
            Arguments.of(new int[] {1, 3}, new int[] {4, 2}),
            Arguments.of(new int[] {-3, -4}, new int[] {-3, -5, -4}),
            Arguments.of(new int[] {0, 2}, new int[] {-1, 1}),
            Arguments.of(new int[] {-3}, new int[] {-3, -4}),
            Arguments.of(new int[] {100, 200}, new int[] {100}),
            Arguments.of(new int[] {100, 200}, new int[] {0})
        );
    }

    @ParameterizedTest
    @DisplayName("isNestable - nested, both arrays filled")
    @MethodSource
    void isNestable_ShouldRWorkGivenNestedFilled(int[] numbers1, int[] numbers2) {
        boolean actual = Task3.isNestable(numbers1, numbers2);

        assertThat(actual).isEqualTo(true);
    }

    private static Stream<Arguments> isNestable_ShouldRWorkGivenNestedFilled() {
        return Stream.of(
            Arguments.of(new int[] {0}, new int[] {-1, 1}),
            Arguments.of(new int[] {-10, 1, 100}, new int[] {99, -11, 1000})
        );
    }



}
