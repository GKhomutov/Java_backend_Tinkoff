package edu.hw1;

public final class Task1 {
    private final static int SECONDS_IN_MINUTE = 60;

    private Task1() {
    }

    /**
     * Converts the length of the video to the number of seconds.
     *
     * @param videoLen video length in "mm:ss" format
     * @return video duration in seconds (0 if null, -1 if incorrect format)
     */
    public static int minutesToSeconds(String videoLen) {
        final String pattern = "\\d{2,}:\\d{2}";
        if (videoLen == null) {
            return 0;
        }
        if (!videoLen.matches(pattern)) {
            return -1;
        }
        String[] parts = videoLen.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        if (seconds >= SECONDS_IN_MINUTE) {
            return -1;
        }
        return SECONDS_IN_MINUTE * minutes + seconds;
    }

}
