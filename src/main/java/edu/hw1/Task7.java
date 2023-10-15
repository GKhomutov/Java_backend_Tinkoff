package edu.hw1;

public final class Task7 {
    private final static org.apache.logging.log4j.Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger();

    private Task7() {
    }

    /**
     * Performs right cyclic shift.
     *
     * @param number a positive integer to be rotated
     * @param shift rotation value
     * @return rotated number
     * @throws IllegalArgumentException if number is non-positive
     */
    public static int rotateLeft(int number, int shift) {
        return rotateRight(number, -shift);
    }

    /**
     * Performs right cyclic shift.
     *
     * @param number a positive integer to be rotated
     * @param shift rotation value
     * @return rotated number
     * @throws IllegalArgumentException if number is non-positive
     */
    public static int rotateRight(int number, int shift) {
        if (number <= 0) {
            throw new IllegalArgumentException("The number must be positive for rotation");
        }
        int numOfBits = countBits(number);
        if (shift > 0) {
            int realShift = shift % numOfBits;
            LOGGER.trace(realShift);
            return ((1 << numOfBits) - 1) & ((number >> realShift) | (number << (numOfBits - realShift)));
        } else {
            int realShift = (-shift) % numOfBits;
            return ((1 << numOfBits) - 1) & ((number << realShift) | (number >> (numOfBits - realShift)));
        }
    }

    /**
     * Counts the number of bits in an integer.
     *
     * @param number integer
     * @return number of significant bits in number
     */
    private static int countBits(int number) {
        int n = number;
        int res = 0;
        while (n > 0) {
            n >>= 1;
            ++res;
        }
        return res;
    }
}
