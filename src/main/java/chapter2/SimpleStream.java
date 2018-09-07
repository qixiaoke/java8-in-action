package chapter2;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleStream {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH) );

//        List<String> dishes = getDishName(menu);
        List<String> dishes = getDiskNameByStreamP(menu);
        System.out.println(dishes);
    }

    // 1
    public static List<String> getDishName(List<Dish> dishes) {
        List<Dish> lowDish = new ArrayList<>();

        for (Dish dish : dishes) {
            if(dish.getCalories() < 400) {
                lowDish.add(dish);
            }
        }

        // 测试线程情况
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Collections.sort(lowDish, Comparator.comparing(Dish::getCalories));

        List<String> result = new ArrayList<>();
        for(Dish dish : lowDish) {
            result.add(dish.getName());
        }

        return result;
    }

    // 2
    public static List<String> getDiskNameByStream(List<Dish> dishes) {
        return dishes.stream().filter(d -> {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return d.getCalories()<400;
        }).sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).collect(Collectors.toList());
    }

    // 3
    public static List<String> getDiskNameByStreamP(List<Dish> dishes) {
        return dishes.parallelStream().filter(d -> {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return d.getCalories()<400;
        }).sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).collect(Collectors.toList());
    }
}
