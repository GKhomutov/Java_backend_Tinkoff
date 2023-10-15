package edu.hw1;

public final class Task2 {
    private final static int BASE = 10;

    private Task2() {
    }

    /**
     * Counts the number of digits in a given integer.
     *
     * @param number an integer to calculate digits in
     * @return number of digits in decimal base
     */
    public static int countDigits(int number) {
        int n = Math.abs(number);
        if (n == 0) {
            return 1;
        }
        int cnt = 0;
        while (n > 0) {
            n /= BASE;
            ++cnt;
        }
        return cnt;
    }
}
