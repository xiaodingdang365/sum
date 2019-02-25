package guava;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderExample {
    public static List list = Lists.newArrayList(5,2,15,51,null,53,35,45);

    @Test
    public void test1(){
        Ordering ordering = Ordering.arbitrary().nullsLast();

        System.out.println(list);
        Collections.sort(list,ordering);
        System.out.println(list);
    }

    @Test
    public void test2(){
        Map map = new HashMap();
        Map subMap = new HashMap();
        map.put("map",subMap);
        subMap.put("test",'3');
        System.out.println(map);
    }


}
