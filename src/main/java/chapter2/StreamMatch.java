package chapter2;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMatch {

    public static void main(String[] args) {

        Integer[] is = new Integer[]{1, 2, 3, 4, 5, 6};

        Stream<Integer> stream = Arrays.stream(is);
        boolean matched = stream.allMatch(x -> x > 10);
        System.out.println(matched);

        stream = Arrays.stream(is);
        matched = stream.anyMatch(x -> x > 5);
        System.out.println(matched);

        stream = Arrays.stream(is);
        matched = stream.noneMatch(x -> x < 0);
        System.out.println(matched);

    }
}
