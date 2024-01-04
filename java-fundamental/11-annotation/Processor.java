import java.lang.reflect.Method;

public class Processor {
    // annotation เป็นแค่ tag ทำงานด้วยตัวเองไม่ได้
    public static void processAnnotation(Object target) {
        // class ทุก class มาจาก java.lang.Object
        Class<?> thisClass = target.getClass();
        Method[] methods = thisClass.getDeclaredMethods();
        // get list of method จาก class

        for (Method method : methods) {
            GetMapping getMapping = method.getAnnotation(GetMapping.class);
            // ดูว่า method มี @GetMapping หรือไม่
            // Object.class จะได้ type ของ class
            if (getMapping != null) {
                System.out.println("Do something here - GetMapping: " + method.getName());
            }
        }
    }
}
