import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// ใช้ annotation ตอน runtime
@Target(ElementType.METHOD)
// ใช้ annotation ที่ method
public @interface GetMapping {
    // annotation เป็น interface ในลักษณะหนึ่ง
}
