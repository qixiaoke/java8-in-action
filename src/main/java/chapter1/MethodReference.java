package chapter1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReference {

    public static <T> void useConsumer(Consumer<T> c, T t) {
        c.accept(t);
    }


    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(new Apple("yellow", 150), new Apple("red", 100), new Apple("green", 120));

        // 1
//        useConsumer(t -> System.out.println(t), "abc");

        // 2
//        useConsumer(System.out::println, "abc");

        // 3
//        apples.sort((a1, a2) -> a1.getColor().compareTo(a2.getColor()));
//        System.out.println(apples);

        // 4
//        apples.stream().forEach(a -> System.out.println(a));
//        apples.stream().forEach(System.out::println);

        // 5

    }
}
