package chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CreateStream {

    // 1
//    public static Stream<String> createStream() {
//        List<String> strings = Arrays.asList("1", "2", "3");
//
//        return strings.stream();
//    }

    // 2
//    public static Stream<String> createStream() {
//        Stream<String> stringStream = Stream.of("1", "2", "3");
//
//        return stringStream;
//    }

    // 3
//    public static Stream<String> createStream() {
//        String[] strings = {"1", "2", "3"};
//        return Arrays.stream(strings);
//    }

    // 4
//    public static Stream<String> createStream() {
//        Path path = Paths.get("/Users/qixin/export.json");
//        try(Stream<String> lines = Files.lines(path)) {
//            lines.forEach(System.out::println);
//            return lines;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    // 5
//    public static Stream<Integer> createStream() {
//        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2).limit(10);
//        return iterate;
//    }

    // 6
//    public static Stream<Double> createStream() {
//        return Stream.generate(Math::random).limit(10);
//    }

    // 7
    public static Stream<Object> createStream() {
        Stream<Object> stream = Stream.generate(new Supplier<Object>() {
            @Override
            public Object get() {
                return new Obj(new Random(System.currentTimeMillis()).nextInt(), "name");
            }
        }).limit(10);

        return stream;
    }

    static class Obj {
        private int index;
        private String name;

        public Obj(int index, String name) {
            this.index = index;
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "index=" + index +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
//        Stream<String> stream = createStream();
//        stream.forEach(System.o?ut::println);
//        Stream<Integer> stream = createStream();
//        Stream<Double> stream = createStream();
        Stream<Object> stream = createStream();
        stream.forEach(System.out::println);
    }
}
