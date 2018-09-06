package chapter1;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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

        // 5 类方法推导
//        int value = Integer.parseInt("123");
//        System.out.println(value);
//
//        Function<String, Integer> f = Integer::parseInt;
//        Integer result = f.apply("123");
//        System.out.println(result);

        // 6 实例方法推导
//        BiFunction<String, Integer, Character> f = String::charAt;
//        Character c = f.apply("abc", 2);
//        System.out.println(c);

        // 7 对象的实例方法推导
//        String str = new String("abc");
//        Function<Integer, Character> f = str::charAt;
//        Character c = f.apply(2);
//        System.out.println(c);

        // 8 构造函数推导
//        Supplier<String> s = String::new;
//        String str = s.get();
//
//        BiFunction<String, Integer, Apple> biFunction = Apple::new;
//        Apple apple = biFunction.apply("green", 120);
//        System.out.println(apple);

        ThreeFunction<String, Integer, String, ThreeParamApple> t = ThreeParamApple::new;
        ThreeParamApple apple = t.apply("green", 120, "green apple");
        System.out.println(apple);
    }

    @FunctionalInterface
    public interface ThreeFunction<U, R, L, N> {
        N apply(U u, R r, L l);
    }

    static class ThreeParamApple {
        private String color;
        private int weight;
        private String name;

        public ThreeParamApple(String color, int weight, String name) {
            this.color = color;
            this.weight = weight;
            this.name = name;
        }

        @Override
        public String toString() {
            return "ThreeParamApple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
