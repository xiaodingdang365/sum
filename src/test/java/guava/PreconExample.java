package guava;

import com.google.common.base.Preconditions;
import org.junit.*;

public class PreconExample {

    public double sqrt(double input) {
        Preconditions.checkArgument(input > 0.0, "参数不合法 %s", input);
        return Math.sqrt(input);
    }

    public int sum(Integer a, Integer b) {
        a = Preconditions.checkNotNull(a, "is null");
        b = Preconditions.checkNotNull(b, "is null");
        return a + b;
    }

    public int getValue(int input) {
        int[] data = {1, 2, 3, 4, 5};
        int a = Preconditions.checkElementIndex(input, data.length, "index is not valid");
        return a;
    }

    @Test
    public void test1() {
        PreconExample example = new PreconExample();
//        System.out.println(example.sqrt(-3.0));
//        System.out.println(example.sum(null,3));
        System.out.println(example.getValue(6));
    }
}
