package chapter04;

import static util.PrintUtil.print;

/**
 * 문제 015. 수 정렬하기 1
 * N 개의 수가 주어졌을 때 이를 오름차순 정렬하는 프로그램을 작성하시오.
 * - 1 <= N <= 1,000
 * [Solution]
 * - N 의 최대 범위가 1,000 으로 작기 때문에 O(n^2) 시간 복잡도 알고리즘으로 정렬 알고리즘 구현한다.
 * - 버블 정렬 알고리즘 활용
 *
 */
public class Question015 {

    public static void main(String[] args) {
        solution(new int[]{5, 2, 3, 4, 1});
    }

    private static void solution(int[] A) {
        int N = A.length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }

        System.out.print("answer = ");
        print(A);
    }

}
