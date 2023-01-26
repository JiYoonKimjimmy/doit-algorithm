package chapter04;

import static util.PrintUtil.print;

/**
 * 문제 017. 내림차순으로 자릿수 정렬하기
 * 주어진 수 문자열 N을 각 자릿수를 내림차순 정렬하는 프로그램을 작성하시오.
 * - 1 <= N <= 1,000,000,000
 * [Solution]
 * - 선택 정렬을 활용하여 문제 접근한다. (선택 정렬의 시간 복잡도 : O(N^2))
 */
public class Question017 {

    public static void main(String[] args) {
        solution("2143");
    }

    private static void solution(String N) {
        char[] C = N.toCharArray();
        int[] A = new int[N.length()];
        for (int i = 0; i < C.length; i++) {
            A[i] = Character.getNumericValue(C[i]);
        }

        for (int i = 0; i < A.length; i++) {
            int max = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[max] < A[j]) {
                    max = j;
                }
            }

            if (A[max] > A[i]) {
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }

        System.out.print("answer = ");
        print(A);
    }

}
