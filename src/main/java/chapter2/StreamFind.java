package chapter2;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFind {

    public static void main(String[] args) {

        Integer[] is = new Integer[]{1, 2, 3, 4, 5, 6};

        // 1
        Stream<Integer> stream = Arrays.stream(is);
//        Optional optional1 = stream.filter(x -> x % 2 == 0).findAny();
//        System.out.println(optional1.get());

        // 3
        Optional optional = stream.filter(x -> x >= 10).findAny();
        System.out.println(optional.orElse(-1));

        // 2
        stream = Arrays.stream(is);
        Optional<Integer> optional2 = stream.filter(x -> x % 2 == 0).findFirst();
        System.out.println(optional2.get());

        // 4
        optional2.ifPresent(System.out::println);

        //5
        System.out.println(optional2.filter(x -> x == 2).get());
    }
}
