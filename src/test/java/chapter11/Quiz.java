package chapter11;

import org.junit.jupiter.api.Test;

import java.util.Properties;

import static chapter11.Quiz3.readDuration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Quiz {
    @Test
    public void testQuiz11_3() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        assertEquals(5, readDuration(props, "a"));
        assertEquals(0, readDuration(props, "b"));
        assertEquals(0, readDuration(props, "c"));
        assertEquals(0, readDuration(props, "d"));
    }
}
