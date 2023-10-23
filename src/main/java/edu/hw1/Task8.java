package edu.hw1;

@SuppressWarnings("MagicNumber")
public final class Task8 {
    private final static int[] DX = {1, 2, 2, 1, -1, -2, -2, -1};
    private final static int[] DY = {2, 1, -1, -2, -2, -1, 1, 2};
    private final static int BOARD_SIZE = 8;

    private Task8() {
    }

    /**
     * Checks if no knight can capture one another knight.
     *
     * @param board chessboard consisting of 0 and 1
     * @return true if the knights are safe, false otherwise
     * @throws IllegalArgumentException if board is null or not 8x8 size or contains numbers other than 0 and 1
     */
    public static boolean knightBoardCapture(int[][] board) {
        if (board == null) {
            throw new IllegalArgumentException("Board must be non-null");
        }
        boolean badSize = false;
        if (board.length != BOARD_SIZE) {
            badSize = true;
        } else {
            for (int i = 0; i < BOARD_SIZE; ++i) {
                if (board[i] == null) {
                    throw new IllegalArgumentException("Board must have non-null rows");
                }
                if (board[i].length != BOARD_SIZE) {
                    badSize = true;
                    break;
                }
            }
        }
        if (badSize) {
            throw new IllegalArgumentException("Board must have 8 rows and 8 columns");
        }

        for (int i = 0; i < BOARD_SIZE; ++i) {
            for (int j = 0; j < BOARD_SIZE; ++j) {
                if (board[i][j] != 0 && board[i][j] != 1) {
                    throw new IllegalArgumentException("Board must consist of 0 and 1");
                }
                for (int k = 0; k < DX.length; ++k) {
                    int x = i + DX[k];
                    int y = j + DY[k];
                    if (fieldIsValid(x, y) && board[i][j] == 1 && board[x][y] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Checks whether given cell is presented on the chessboard.
     *
     * @param i row number
     * @param j column number
     * @return true if such a field exists, false otherwise
     */
    private static boolean fieldIsValid(int i, int j) {
        return (0 <= i) && (i < BOARD_SIZE) && (0 <= j) && (j < BOARD_SIZE);
    }
}
