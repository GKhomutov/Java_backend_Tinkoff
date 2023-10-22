package edu.hw2.Task4;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    void callingInfo_ShouldWork() {
        CallingInfo actual = Task4.callingInfo();

        CallingInfo expected = new CallingInfo("edu.hw2.Task4.Task4Test", "callingInfo_ShouldWork");

        assertThat(actual).isEqualTo(expected);
    }
}
