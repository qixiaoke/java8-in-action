package chapter2;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStream {

    public static void main(String[] args) {

        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        IntStream intStream = stream.mapToInt(i -> i.intValue());
        int sum = intStream.filter(i -> i > 3).sum();
        System.out.println(sum);

        IntStream intStream1 = IntStream.rangeClosed(0, 100);
        intStream1.forEach(System.out::println);

        int a = 9;
        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .boxed()
                .map(i -> new Integer[]{a, i, (int) Math.sqrt(a * a + i * i)})
                .forEach(s -> System.out.println("a = " + s[0] + " ,b = " + s[1] + " ,c = " + s[2]));

        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(i -> new Integer[]{a, i, (int)Math.sqrt(a*a + i*i)})
                .forEach(s -> System.out.println("a = " + s[0] + " ,b = " + s[1] + " ,c = " + s[2]));
    }
}
