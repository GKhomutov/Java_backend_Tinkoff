package edu.hw1;


public final class Task5 {
    public final static int BASE = 10;

    private Task5() {
    }

    /**
     * Checks whether the number is a palindrome or any of its descendants is a palindrome.
     *
     * @param number an integer to check
     * @return true if a palindrome exists, false otherwise
     */
    public static boolean isPalindromeDescendant(int number) {
        int n = Math.abs(number);
        while (n >= BASE) {
            if (isPalindrome(n)) {
                return true;
            }
            int descendant = 0;
            int descendantLengthMultiplicator = 1;
            int tmp = n;
            while (tmp > 0) {
                int digit1 = tmp % BASE;
                tmp /= BASE;
                int digit2 = tmp % BASE;
                tmp /= BASE;
                int sum = digit1 + digit2;
                descendant += sum * descendantLengthMultiplicator;
                descendantLengthMultiplicator *= (sum < BASE ? BASE : BASE * BASE);
            }
            n = descendant;
        }
        return false;
    }

    /**
     * Checks if the number is a palindrome or if any of its descendants is a palindrome.
     *
     * @param number an integer to check
     * @return true if a palindrome exists, false otherwise
     */
    private static boolean isPalindrome(int number) {
        return number == reverse(number);
    }

    /**
     * Reverses the digits in a number.
     *
     * @param number an integer to reverse
     * @return reversed number
     */
    private static int reverse(int number) {
        int n = Math.abs(number);
        int reversedNumber = 0;
        while (n > 0) {
            reversedNumber = reversedNumber * BASE + n % BASE;
            n /= BASE;
        }
        return reversedNumber;
    }
}
