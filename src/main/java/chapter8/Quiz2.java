package chapter8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Quiz2 {
    public static void main(String[] args) {
        Map<String, Integer> movies = new HashMap<>();
        movies.put("JamesBond", 20);
        movies.put("Matrix", 15);
        movies.put("Harry Potter", 5);

        Iterator<Map.Entry<String, Integer>> iterator = movies.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 10) {
                iterator.remove();
            }
        }
        System.out.println("movies = " + movies);

        // 개선버전
        Map<String, Integer> moviesAfter = new HashMap<>();
        moviesAfter.put("JamesBond", 20);
        moviesAfter.put("Matrix", 15);
        moviesAfter.put("Harry Potter", 5);

        moviesAfter.entrySet().removeIf(entry -> entry.getValue() < 10);

        System.out.println("moviesAfter = " + moviesAfter);
    }
}
