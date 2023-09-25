package chapter6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static chapter6.Dish.menu;
import static java.util.stream.Collectors.partitioningBy;

public class PartitionByTest {
    /**
     * public static final List<Dish> menu = asList(
     * new Dish("pork", false, 800, Dish.Type.MEAT),
     * new Dish("beef", false, 700, Dish.Type.MEAT),
     * new Dish("chicken", false, 400, Dish.Type.MEAT),
     * new Dish("prawns", false, 400, Dish.Type.FISH),
     * new Dish("salmon", false, 450, Dish.Type.FISH)
     * new Dish("french fries", true, 530, Dish.Type.OTHER),
     * new Dish("rice", true, 350, Dish.Type.OTHER),
     * new Dish("season fruit", true, 120, Dish.Type.OTHER),
     * new Dish("pizza", true, 550, Dish.Type.OTHER),
     * );
     */
    @Test
    @DisplayName("퀴즈 6.2 분할 예측")
    void partitionByTest1() {
        Map<Boolean, Map<Boolean, List<Dish>>> actual = menu.stream().collect(partitioningBy(Dish::isVegetarian,
                partitioningBy(d -> d.getCalories() > 500)));
        Map<Boolean, Map<Boolean, List<String>>> expected = Map.of(
                false, Map.of(
                        false, List.of("chicken", "prawns", "salmon"),
                        true, List.of("pork", "beef")
                ),
                true, Map.of(
                        false, List.of("rice", "season"),
                        true, List.of("pizza")
                )
        );
    }
}
