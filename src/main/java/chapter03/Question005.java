package chapter03;

/**
 * 문제 005. 나머지 합 구하기
 * N 개의 수 연속된 부분의 합이 M 으로 나누어떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
 * [Solution]
 * - 1. 구간 합 배열을 활용하여, M 으로 나누어떨어지는 수의 갯수를 구한다.
 * - 2. 나머지 수들 중에 같은 수의 갯수 별로 2개씩 뽑는 경우의 수를 구한다.
 * - 1 ~ 2번의 수를 모두 합산한다.
 */
public class Question005 {

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 1, 2}, 3);
    }

    private static void solution(int[] A, int M) {
        int answer = 0;
        int[] S = new int[A.length];
        int[] C = new int[A.length];

        S[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            S[i] = S[i - 1] + A[i];
        }

        for (int i = 0; i < A.length; i++) {
            int remainder = S[i] % M;
            if (remainder == 0) answer++;
            C[remainder]++;
        }

        for (int c : C) {
            if (c > 1) {
                answer += c * (c - 1) / 2;
            }
        }

        System.out.println("answer = " + answer);
    }

}
