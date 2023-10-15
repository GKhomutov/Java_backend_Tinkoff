package edu.hw1;

public final class Task3 {
    private Task3() {
    }

    /**
     * Checks whether one array can be nested within another array.
     *
     * @param numbers1 the integer array to be nested
     * @param numbers2 the integer array to be nested in
     * @return true if nesting is possible, false otherwise
     */
    public static boolean isNestable(int[] numbers1, int[] numbers2) {
        if (numbers1 == null || numbers2 == null) {
            return false;
        }
        if (numbers2.length == 0) {
            return false;
        }
        if (numbers1.length == 0) {
            return true;
        }
        int min1 = getMin(numbers1);
        int max1 = getMax(numbers1);
        int min2 = getMin(numbers2);
        int max2 = getMax(numbers2);
        return min2 < min1 && max1 < max2;
    }

    /**
     * Finds the maximum in a given array.
     *
     * @param numbers the array of integers
     * @return the maximal element in numbers
     * @throws IllegalArgumentException if numbers is null or empty
     */
    private static int getMax(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("To find the maximum, the array must be non-null");
        }
        if (numbers.length == 0) {
            throw new IllegalArgumentException("To find the maximum, the array must be non-empty");
        }
        int res = numbers[0];
        for (int number : numbers) {
            res = Math.max(res, number);
        }
        return res;
    }

    /**
     * Finds the minimum in a given array.
     *
     * @param numbers the array of integers
     * @return the minimal element in numbers
     * @throws IllegalArgumentException if numbers is null or empty
     */
    private static int getMin(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("To find the minimum, the array must be non-null");
        }
        if (numbers.length == 0) {
            throw new IllegalArgumentException("To find the minimum, the array must be non-empty");
        }
        int res = numbers[0];
        for (int number : numbers) {
            res = Math.min(res, number);
        }
        return res;
    }
}
