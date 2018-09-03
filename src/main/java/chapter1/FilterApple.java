package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApple {

    // 1
    public static List<Apple> findGreenApple(List<Apple> apples) {

        List<Apple> list = new ArrayList<>();

        for(Apple apple : apples) {
            if("green".equals(apple.getColor())) {
                list.add(apple);
            }
        }

        return list;
    }

    // 2
    public static List<Apple> findApple(List<Apple> apples, String color) {

        List<Apple> list = new ArrayList<>();

        for(Apple apple : apples) {
            if(color.equals(apple.getColor())) {
                list.add(apple);
            }
        }

        return list;
    }

    // 3
    @FunctionalInterface
    public interface AppleFilter {
        boolean filter(Apple apple);
    }

    public static List<Apple> findApple(List<Apple> apples, AppleFilter applefilter) {
        List<Apple> list = new ArrayList<>();

        for(Apple apple : apples) {
            if(applefilter.filter(apple)) {
                list.add(apple);
            }
        }
        return list;
    }

    public static class GreenAnd150WeightFilter implements AppleFilter {

        @Override
        public boolean filter(Apple apple) {
            return "green".equals(apple.getColor()) && apple.getWeight() > 140;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Apple> apples = Arrays.asList(new Apple("green", 150), new Apple("red", 100), new Apple("yellow", 120));

        // 1
//        List<Apple> greenApples = findGreenApple(apples);
//        System.out.println(greenApples);

        // 2
//        List<Apple> greenApples = findApple(apples, "green");
//        System.out.println(greenApples);

//        List<Apple> redApples = findApple(apples, "red");
//        System.out.println(redApples);

        // 3
//        List<Apple> result = findApple(apples, new GreenAnd150WeightFilter());
//        System.out.println(result);

        // 4
//        List<Apple> result = findApple(apples, new AppleFilter() {
//            @Override
//            public boolean filterByPredicate(Apple apple) {
//                return "green".equals(apple.getColor()) && apple.getWeight() > 140;
//            }
//        });
//        System.out.println(result);

        // 5
//        List<Apple> result = findApple(apples, (Apple apple) -> {
//           return "green".equals(apple.getColor()) && apple.getWeight() > 140;
//        });
//        System.out.println(result);

        // 6
//        List<Apple> result = findApple(apples, apple -> {
//            return "green".equals(apple.getColor());
//        });
//        System.out.println(result);

        // 7
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        }).start();
//
//        Thread.currentThread().join();

        // 8
//        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
//
//        Thread.currentThread().join();
    }
}
