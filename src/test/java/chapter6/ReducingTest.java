package chapter6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chapter6.Dish.menu;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;
import static org.assertj.core.api.Assertions.assertThat;

class ReducingTest {
    @Test
    @DisplayName("퀴즈 6.1 리듀싱으로 문자열 연결하기")
    void reducing_join_string() {
        String expected = menu.stream().map(Dish::getName).collect(joining());

        String actual1 = menu.stream().map(Dish::getName).collect(reducing((s1, s2) -> s1 + s2)).get();
        String actual2 = menu.stream().collect(reducing("", Dish::getName, (s1, s2) -> s1 + s2));

        assertThat(actual1).isEqualTo(expected);
        assertThat(actual2).isEqualTo(expected);
    }
}
