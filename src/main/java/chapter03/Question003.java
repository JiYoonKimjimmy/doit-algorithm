package chapter03;

import util.PrintUtil;

/**
 * 문제 003. 구간 합 구하기
 * - 수 N 개의 i 번째 수에서 j 번째 수까지의 합을 구하는 프로그램을 작성하시오.
 * [Solution]
 * - 구간 합 공식 활용
 * [구간 합 공식]
 * - A[2] ~ A[5] 까지의 구간 합 구하기
 * - S[5] = A[0] + A[1] + A[2] + A[3] + A[4] + A[5]
 * - S[1] = A[0] + A[1]
 * - S[5] - S[1] = A[2] + A[3] + A[4] + A[5]
 */
public class Question003 {

    public static void main(String[] args) {
        solution(new int[]{5, 4, 3, 2, 1}, 1, 3);
        solution(new int[]{5, 4, 3, 2, 1}, 2, 4);
        solution(new int[]{5, 4, 3, 2, 1}, 5, 5);
    }

    private static void solution(int[] A, int s, int e) {
        int[] S = new int[A.length + 1];

        S[1] = A[0];
        for (int i = 1; i < A.length; i++) {
            S[i + 1] = S[i] + A[i];
        }
        int result = S[e] - S[s - 1];
        System.out.println("result = " + result);
    }

}
