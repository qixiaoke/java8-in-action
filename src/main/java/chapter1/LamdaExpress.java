package chapter1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LamdaExpress {

    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(new Apple("yellow", 150), new Apple("red", 100), new Apple("green", 120));

        // 1
//        Comparator<Apple> byColor = new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getColor().compareTo(o2.getColor());
//            }
//        };
//
//
//        apples.sort(byColor);
//
//        System.out.println(apples);

        // 2
//        Comparator<Apple> byColor = (Apple o1, Apple o2) -> o1.getColor().compareTo(o2.getColor());
//
//        apples.sort(byColor);
//
//        System.out.println(apples);

        // 3
//        Comparator<Apple> byColor = (o1, o2) -> o1.getColor().compareTo(o2.getColor());
//
//        apples.sort(byColor);
//
//        System.out.println(apples);

        // 4
        Function<String, Integer> flamda = s -> s.length();

        Predicate<Apple> plamda = apple -> "green".equals(apple.getColor());
        // 等价
        Function<Apple, Boolean> f = apple -> "green".equals(apple.getColor());
    }
}
