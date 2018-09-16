package chapter2.a6;

import chapter1.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorIntroduce {

    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(new Apple("yellow", 150),
                new Apple("red", 100),
                new Apple("yellow", 200),
                new Apple("green", 120));

        // 聚合
        List<Apple> list = apples.stream().filter(t -> t.getColor().equals("yellow")).collect(Collectors.toList());
        Optional.ofNullable(list).ifPresent(System.out::println);

        // 分组
        Map<String, List<Apple>> collect = apples.stream().collect(Collectors.groupingBy(Apple::getColor));
        System.out.println(collect);
    }
}
