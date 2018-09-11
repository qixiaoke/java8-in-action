package chapter2;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamReduce {

    public static void main(String[] args) {

        Integer[] is = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Stream<Integer> stream = Arrays.stream(is);

        // 1
        Integer result = stream.reduce(0, (i, j) -> i + j);
        System.out.println(result);

        // 2
        stream = Arrays.stream(is);
        stream.reduce((i, j) -> i + j).ifPresent(System.out::println);

        // 3
        stream = Arrays.stream(is);
        System.out.println(stream.reduce(0, Integer::sum));

        // 4
        stream = Arrays.stream(is);
        stream.reduce((i, j) -> i > j ? i : j).ifPresent(System.out::println);
    }
}
