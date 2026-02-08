package util;

public class ReflectionUtil {

    public static void inspect(Object obj) {
        Class<?> cls = obj.getClass();

        System.out.println("Class: " + cls.getName());

        System.out.println("Fields:");
        for (var f : cls.getDeclaredFields()) {
            System.out.println(" - " + f.getName());
        }

        System.out.println("Methods:");
        for (var m : cls.getDeclaredMethods()) {
            System.out.println(" - " + m.getName());
        }
    }
}
