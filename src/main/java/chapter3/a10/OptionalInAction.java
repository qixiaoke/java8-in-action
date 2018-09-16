package chapter3.a10;

import java.util.Optional;

public class OptionalInAction {

    public static void main(String[] args) {
        Optional.ofNullable(getInsuranceByOptional(null)).ifPresent(System.out::println);
    }

    private static String getInsuranceByOptional(Person person) {

        return Optional.ofNullable(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unknown");
    }
}
