package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {
    @ParameterizedTest
    @DisplayName("knightBoardCapture - null board")
    @NullSource
    void knightBoardCapture_ShouldThrowExceptionForNullArray(int[][] board) {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            boolean result = Task8.knightBoardCapture(board);
        });

        Assertions.assertEquals("Board must be non-null", thrown.getMessage());
    }

    @Test
    @DisplayName("knightBoardCapture - incorrect dimensions")
    void knightBoardCapture_ShouldThrowExceptionForBoardWithIncorrectDimensions() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            boolean result = Task8.knightBoardCapture(new int[][] {{0, 1}});
        });

        Assertions.assertEquals("Board must have 8 rows and 8 columns", thrown.getMessage());
    }

    @Test
    @DisplayName("knightBoardCapture - incorrect board numbers")
    void knightBoardCapture_ShouldThrowExceptionForBoardWithIncorrectNumbers() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            boolean result = Task8.knightBoardCapture(
                new int[][] {
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 10},
                }
            );
        });

        Assertions.assertEquals("Board must consist of 0 and 1", thrown.getMessage());
    }

    @Test
    @DisplayName("knightBoardCapture - correct board true")
    void knightBoardCapture_ShouldWorkGivenCorrectBoardTrue() {
        boolean actual = Task8.knightBoardCapture(
            new int[][] {
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}
            }
        );

        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("knightBoardCapture - correct board false")
    void knightBoardCapture_ShouldWorkGivenCorrectBoardFalse() {
        boolean actual = Task8.knightBoardCapture(
            new int[][] {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
            }
        );

        assertThat(actual).isFalse();
    }
}
