package chapter03;

import java.util.Arrays;

import static util.PrintUtil.print;

/**
 * 문제 007. 주몽의 명령
 * 주몽의 철기군 양성 프로젝트를 위해 2가지 재표의 번호를 합산하여 M 이 되는 갑옷을 몇개나 만들 수 있는지 구하는 프로그램을 작성하시오. (N 개의 재료가 주어진다.)
 * - 1 <= M <= 10,000,000
 * - 1 <= N <= 15,000
 * [Solution]
 * - 주어진 N 숫자 배열을 정렬한다.
 * - 정렬된 배열을 투 포인터를 활용하여 문제 해결한다.
 * - 투 포인터를 배열 양 끝으로 위치하여 탐색을 시작한다.
 */
public class Question007 {

    public static void main(String[] args) {
        solution(new int[]{2, 7, 4, 1, 5, 3}, 9);
    }

    private static void solution(int[] A, int M) {
        int answer = 0;

        print(A);
        Arrays.sort(A);
        print(A);

        int start = 0, end = A.length - 1;

        while (start < end) {
            int sum = A[start] + A[end];
            if (sum < M) {
                start++;
            } else if (sum > M) {
                end--;
            } else {
                answer++;
                start++;
                end--;
            }
        }

        System.out.println("answer = " + answer);
    }

}
