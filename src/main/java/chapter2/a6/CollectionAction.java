package chapter2.a6;

import chapter2.Dish;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionAction {

    private final static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));


    public static void main(String[] args) {

        averageDouble();
        averageInt();
        averageLong();
//        collectingAndThen();
        count();
        groupingByFunction();
        groupingByFunctionAndCollector();
        groupingByFunctionAndSupplierAndCollector();
        testSummary();
    }

    private static void averageDouble() {
        Optional.ofNullable(menu.stream().collect(Collectors.averagingDouble(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void averageInt() {
        Optional.ofNullable(menu.stream().collect(Collectors.averagingInt(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void averageLong() {
        Optional.ofNullable(menu.stream().collect(Collectors.averagingLong(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void collectingAndThen() {
        Optional.ofNullable(menu.stream().collect(Collectors
                .collectingAndThen(Collectors.averagingDouble(Dish::getCalories), a -> "average is " + a)))
                .ifPresent(System.out::println);

        List<Dish> list = menu.stream().collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        list.add(new Dish("", true, 123, Dish.Type.OTHER));
    }

    private static void count() {
        Optional.ofNullable(menu.stream().collect(Collectors.counting())).ifPresent(System.out::println);
    }

    private static void groupingByFunction() {
        Optional.ofNullable(menu.stream().collect(Collectors.groupingBy(Dish::getType)))
                .ifPresent(System.out::println);
    }

    private static void groupingByFunctionAndCollector() {
        Optional.ofNullable(menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting())))
                .ifPresent(System.out::println);

        Optional.ofNullable(menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.averagingDouble(Dish::getCalories))))
                .ifPresent(System.out::println);

    }

    private static void groupingByFunctionAndSupplierAndCollector() {
        Map<Dish.Type, Double> map = menu.stream().collect(Collectors.groupingBy(Dish::getType, TreeMap::new, Collectors.averagingDouble(Dish::getCalories)));

        System.out.println(map.getClass());

        Optional.ofNullable(map).ifPresent(System.out::println);

    }

    private static void testSummary() {
        Optional.ofNullable(menu.stream().collect(Collectors.summarizingInt(Dish::getCalories)))
                .ifPresent(System.out::println);
    }
}
