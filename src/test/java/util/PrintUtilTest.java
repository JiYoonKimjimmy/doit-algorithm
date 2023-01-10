package util;

import org.junit.jupiter.api.Test;

public class PrintUtilTest {

    @Test
    void INT_배열_print_테스트() {
        int[] A = {1, 2, 3, 4, 5};
        print(A);
    }

    @Test
    void generic_배열_print_테스트() {
        Integer[] A = {1, 2, 3, 4, 5};
        String[] B = {"A", "B", "C"};
        print(A);
        print(B);
    }

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
