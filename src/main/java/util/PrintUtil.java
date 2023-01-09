package util;

public class PrintUtil {

    public static void print(int[] A) {
        for (int a: A) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static <T> void print(T[] A) {
        for (T a: A) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

}
