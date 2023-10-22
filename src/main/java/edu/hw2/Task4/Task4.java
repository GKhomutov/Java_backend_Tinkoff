package edu.hw2.Task4;

public final class Task4 {
    private Task4() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        StackTraceElement info = trace[2];
        return new CallingInfo(info.getClassName(), info.getMethodName());
    }
}
