package edu.hw1;

import java.util.Arrays;

public final class Task6 {
    private final static int BASE = 10;

    private Task6() {
    }

    /**
     * Determines the number of Kaprekar's steps to get the Kaprekar's constant from a given number.
     *
     * @param number four-digit integer with 2 or more distinct digits
     * @return the number of Kaprekar's algorithm steps or -1 if the argument is incorrect
     */
    public static int countK(int number) {
        final int NUM_OF_DIGITS = 4;
        final int KAPERKARS_CONSTANT = 6174;
        int n = Math.abs(number);
        if (Task2.countDigits(n) > NUM_OF_DIGITS) {
            return -1;
        }
        if (number == KAPERKARS_CONSTANT) {
            return 0;
        }
        int[] digits = new int[NUM_OF_DIGITS];
        int tmp = n;
        for (int i = 0; i < NUM_OF_DIGITS; ++i) {
            digits[i] = tmp % BASE;
            tmp /= BASE;
        }
        Arrays.sort(digits);
        if (digits[0] == digits[NUM_OF_DIGITS - 1]) {
            return -1;
        }
        int n1 = 0;
        for (int i = 0; i < NUM_OF_DIGITS; ++i) {
            n1 = n1 * BASE + digits[i];
        }
        int n2 = 0;
        for (int i = NUM_OF_DIGITS - 1; i >= 0; --i) {
            n2 = n2 * BASE + digits[i];
        }
        int k = countK(n2 - n1);
        return (k == -1 ? k : 1 + k);
    }
}
