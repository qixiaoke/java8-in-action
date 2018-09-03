package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class LamdaUage {

    @FunctionalInterface
    public interface Adder {

        int add(int a, int b);
    }

//    @FunctionalInterface 此时会报错，因为不是唯一接口函数
    public interface SmartAdder extends Adder {

        long add(long a, long b);
    }

    @FunctionalInterface
    public interface Empty extends Adder {

    }

    //    @FunctionalInterface 此时会报错，没有接口函数
    public interface DoNothing {


    }

    public static List<Apple> filterByPredicate(List<Apple> apples, Predicate<Apple> predicate) {

        List<Apple> result = new ArrayList<>();
        for(Apple apple : apples) {
            if(predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterWeight(List<Apple> apples, LongPredicate longPredicate) {

        List<Apple> list = new ArrayList<>();

        for(Apple apple : apples) {
            if(longPredicate.test(apple.getWeight())) {
                list.add(apple);
            }
        }

        return list;
    }

    public static List<Apple> filterByPredicate(List<Apple> apples, BiPredicate<String, Integer> biPredicate) {

        List<Apple> list = new ArrayList<>();

        for(Apple apple : apples) {
            if(biPredicate.test(apple.getColor(), apple.getWeight())) {
                list.add(apple);
            }
        }

        return list;
    }

    public static void testConsumer(List<Apple> apples, Consumer<Apple> appleConsumer) {

        for(Apple apple : apples) {
            appleConsumer.accept(apple);
        }

    }

    public static void testBiConsumer(List<Apple> apples, String a, BiConsumer<Apple, String> biConsumer) {

        for(Apple apple : apples) {
            biConsumer.accept(apple, a);
        }
    }

    public static String testFunction(Apple apple, Function<Apple, String> function) {
        return function.apply(apple);
    }

    public static Apple testSupplier(Supplier<Apple> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(new Apple("yellow", 150), new Apple("red", 100), new Apple("green", 120));

        // 1
//        Runnable r1 = () -> System.out.println("hello");
//
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello");
//            }
//        };
//
//        process(r1);
//        process(r2);
//        process(() -> System.out.println("hello"));

        // 2
//        List<Apple> filterByPredicate = filterByPredicate(apples, apple -> "green".equals(apple.getColor()));
//        System.out.println(filterByPredicate);

        // 3
//        List<Apple> wFilter = filterWeight(apples, w -> w > 130);
//        System.out.println(wFilter);

        // 4
//        List<Apple> filter = filterByPredicate(apples, (c, w) -> "green".equals(c) && w > 100);
//        System.out.println(filter);

        // 5
//        testConsumer(apples, a -> System.out.println(a));

        // 6
//        testBiConsumer(apples, "XX", (a, b) -> System.out.println(b + "," + a));

        // 7
//        String result = testFunction(new Apple("yello", 120), a -> a.toString());
//        System.out.println(result);

        // 8
//        LongFunction<Double> c = a -> a * 100.0;
//        System.out.println(c.apply(100));

        // 9
//        BiFunction<String, Integer, Apple> biFunction = (c, w) -> new Apple(c, w);
//        Apple apple = biFunction.apply("blue", 120);
//        System.out.println(apple);

        // 10
//        Apple apple = testSupplier(() -> new Apple("green", 120));
//        System.out.println(apple);
    }

    public static void process(Runnable r) {
        r.run();
    }
}
