package chapter2.a6;

import chapter2.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class CollectorAction2 {

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

        averageCurrent();
        join();
        joinWithDelimiter();
        joinWithDelimiterAndPrefixAndSuffix();
        mapping();
        maxBy();
        minBy();
    }

    private static void averageCurrent() {
        ConcurrentMap<Dish.Type, Double> map = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(map).ifPresent(System.out::println);
    }

    private static void join() {
        Optional.ofNullable(menu.stream().map(Dish::getName).collect(Collectors.joining()))
                .ifPresent(System.out::println);
    }

    private static void joinWithDelimiter() {
        Optional.ofNullable(menu.stream().map(Dish::getName).collect(Collectors.joining(",")))
                .ifPresent(System.out::println);
    }

    private static void joinWithDelimiterAndPrefixAndSuffix() {
        Optional.ofNullable(menu.stream().map(Dish::getName).collect(Collectors.joining(",", "[", "]")))
                .ifPresent(System.out::println);
    }

    private static void mapping() {
        Optional.ofNullable(menu.stream().collect(Collectors.mapping(Dish::getName, Collectors.joining(","))))
                .ifPresent(System.out::println);
    }

    private static void maxBy() {
        menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void minBy() {
        menu.stream().collect(Collectors.minBy(Comparator.comparing(Dish::getCalories)))
                .ifPresent(System.out::println);
    }
}
