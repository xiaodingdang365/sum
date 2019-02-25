package guava;

import com.google.common.base.Predicate;
import org.junit.*;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Optional;

public class GuavaStart {
    public static void main(String[] args) {
        GuavaStart guavaStart = new GuavaStart();
        Integer a = null;
        Integer b = new Integer(10);
        System.out.println(guavaStart.sum(a, b));


    }

    public Integer sum(Integer a, Integer b) {
        return a + b;
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println(a.isPresent());
        System.out.println(b.isPresent());

        return a.orElse(new Integer(0)) + b.get();
    }

    @Test
    public void test1() {
        GuavaStart guavaStart = new GuavaStart();
        Integer invalidInput = null;
        Optional<Integer> a = Optional.of(invalidInput);
        Optional<Integer> b = Optional.of(new Integer(10));
        System.out.println(guavaStart.sum(a, b));
    }

    @Test
    public void testOptional(){
        GuavaStart guavaStart = new GuavaStart();
        Integer value1 = null;
        Integer value2 = new Integer(10);
        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> b = Optional.of(value2);

        System.out.println(guavaStart.sum(a,b));


    }
    @Test
    public void testOptional1(){
        Optional<Integer> a = Optional.ofNullable(new Integer(10));
        Optional<Integer> integer = a.filter((Predicate<Integer>) integer1 -> integer1 >5);
        System.out.println(integer.get());
    }

}
