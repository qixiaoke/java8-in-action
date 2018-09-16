package chapter3.a10;

import java.util.Optional;

public class OptionalUsage {

    public static void main(String[] args) {

        Optional<Insurance> empty = Optional.<Insurance>empty();
//        empty.get();

        Optional<Insurance> insurance = Optional.of(new Insurance());
        insurance.get();

        Optional<Insurance> insurance1 = Optional.ofNullable(new Insurance());
        insurance1.orElseGet(Insurance::new);
        insurance1.orElse(new Insurance());
        insurance1.orElseThrow(RuntimeException::new);
        insurance1.orElseThrow(() -> new RuntimeException("no reference"));

        Insurance insurance2 = insurance1.filter(i -> i.getName() == null).get();
        System.out.println(insurance2);

        Optional<String> s = insurance1.map(i -> i.getName());
        System.out.println(s.orElse("no value"));
        System.out.println(s.isPresent() );

        System.out.println(getInstanceNameByOptional(null));
    }

    private static String getInstanceNameByOptional(Insurance insurance) {
        return Optional.ofNullable(insurance).map(Insurance::getName).orElse("unknown");
    }
}
