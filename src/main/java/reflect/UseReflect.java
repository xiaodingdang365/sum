package reflect;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UseReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("reflect.ReflectTest");
        Object o = aClass.newInstance();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field f: declaredFields
             ) {
            f.setAccessible(true);
            String fieldName = f.getName();
            Method declaredMethod1 = aClass.getDeclaredMethod("get" + StringUtils.capitalize(fieldName));

            Method declaredMethod = aClass.getDeclaredMethod("set" + StringUtils.capitalize(fieldName),f.getType());
            declaredMethod.setAccessible(true);
            if("name".equals(fieldName)){
                declaredMethod.invoke(o,"li");
            }



        }
        System.out.println(o.toString());
    }
}
