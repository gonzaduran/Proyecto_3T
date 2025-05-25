package modelo1;

import java.lang.reflect.Field;

public class TestUtils {
    public static Object getField(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo acceder al campo: " + fieldName, e);
        }
    }
}
