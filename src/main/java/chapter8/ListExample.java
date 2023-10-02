package chapter8;

import java.util.Arrays;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // Arrays.asList (ArrayList)
        List<String> friendsArrays = Arrays.asList("Raphael", "Olivia");
        friendsArrays.set(0, "Richard");
        // friendsArrays.add("Thibaut"); // 고정 크기 리스트라 불가능 (UnsupportedOperationException)

        // List.of (ImmutableList)
        List<String> friendsListOf = List.of("Raphael", "Olivia");
        // friendsListOf.set(0, "Richard");  // 변경 불가능 UnsupportedOperationException
        // friendsListOf.add("Thibaut"); //  고정 크기 리스트라 불가능 (UnsupportedOperationException)
    }
}
