package chapter8;

import java.util.List;

public class Quiz1 {
    public static void main(String[] args) {
        List<String> actors = List.of("Keanu", "Jessica");
        actors.set(0, "Brad");
        System.out.println("actors = " + actors);
        // 출력값?
        // List.of는 바꿀수 없음으로 UnsupportOperationException
    }
}
