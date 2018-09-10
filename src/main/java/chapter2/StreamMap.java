package chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 7, 7, 1);

        List<Integer> result = list.stream().map(x -> x * 2).collect(Collectors.toList());
        System.out.println(result);

        List<String> dishes = listDish().stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(dishes);

        String[] words = {"hello", "world"};
        // {h, e, l, l, o}, {w, o, r, l, d}
        Stream<String[]> stream = Arrays.stream(words).map(x -> x.split(""));
        // h, e, l. l. o. w, o, r, l, d
        Stream<String> stringStream = stream.flatMap(Arrays::stream);
        stringStream.forEach(System.out::println);

    }

    public static List<Dish> listDish() {
        return Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH) );

    }
}
