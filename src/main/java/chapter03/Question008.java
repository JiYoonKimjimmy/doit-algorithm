package chapter03;

import java.util.Arrays;

import static util.PrintUtil.print;

/**
 * 문제 008. '좋은 수' 구하기
 * 주어진 N 개의 수에서 다른 두 수의 합으로 표현되는 '좋은 수' 가 총 몇 개인지 출력하는 프로그램을 작성하시오.
 * - 1 <= N <= 2,000
 * - 입력되는 숫자 범위 : 1 <= A <= 1,000,000,000
 * [Solution]
 * - 주어진 배열을 정렬한다.
 * - 정렬된 배열 양 끝의 포인터를 위치시키고, 이동하며 탐색한다.
 * - 포인터를 이동하며 탐색할 때, '좋은 수' 판별 포인터를 두고 비교해간다.
 */
public class Question008 {

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    }

    private static void solution(int[] A) {
        int answer = 0;

        print(A);
        Arrays.sort(A);
        print(A);

        for (int k = 0; k < A.length; k++) {
            int start = 0, end = A.length - 1;

            while (start < end) {
                int sum = A[start] + A[end];
                int find = A[k];
                if (sum == find) {
                    if (start != k && end != k) {
                        answer++;
                        break;
                    } else if (start == k) {
                        start++;
                    } else {
                        end--;
                    }
                } else if (sum < find) {
                    start++;
                } else {
                    end--;
                }

            }
        }

        System.out.println("answer = " + answer);
    }

}
