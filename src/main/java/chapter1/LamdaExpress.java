package chapter1;

import java.util.Comparator;

public class CompareApple {

    public static void main(String[] args) {

        Comparator<Apple> comparator = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o1.getColor());
            }
        }
    }
}
