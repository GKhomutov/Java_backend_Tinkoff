package edu.hw1;

public final class Task4 {
    private Task4() {
    }

    /**
     * Fixes the string by swapping adjacent characters.
     *
     * @param str string to be corrected
     * @return corrected string
     * @throws IllegalArgumentException if str is null
     */
    public static String fixString(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The string must be non-null to be corrected");
        }
        char[] result = str.toCharArray();
        for (int i = 0; i + 1 < str.length(); i += 2) {
            result[i] = str.charAt(i + 1);
            result[i + 1] = str.charAt(i);
        }
        return new String(result);
    }
}
