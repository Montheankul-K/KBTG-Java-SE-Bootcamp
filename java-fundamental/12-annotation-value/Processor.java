import java.lang.reflect.Method;

public class Processor {
    public static void processAnnotation(Object target) {
        Class<?> thisClass = target.getClass();
        Method[] methods = thisClass.getDeclaredMethods();

        for (Method method : methods) {
            GetMapping getMapping = method.getAnnotation(GetMapping.class);
            if (getMapping != null) {
                System.out.println("GetMapping Value: " + getMapping.value());
            }
        }
    }
}
