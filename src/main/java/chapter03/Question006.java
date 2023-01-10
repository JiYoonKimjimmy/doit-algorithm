package chapter03;

import static util.PrintUtil.print;

/**
 * 문제 006. 연속된 자연수의 합 구하기
 * 어떠한 자연수 N 의 몇 개의 연속된 자연수의 합으로 나타낼 수 있는 가짓수를 출력하는 프로그램을 작성하시오.
 * [Solution]
 * - 투 포인터를 활용하여 1 ~ N 까지 나열된 배열을 탐색하여 연속된 자연수 합의 경우의 수를 찾는다.
 * - 자연수의 합 경우의 수 찾는 공식
 *      - sum < N 인 경우, end++ 하고, sum + end
 *      - sum > N 인 경우, sum - start 하고, start++
 *      - sum == N 인 경우, sum + end 하고, answer++
 */
public class Question006 {

    public static void main(String[] args) {
        solution(15);
    }

    private static void solution(int N) {
        int[] A = new int[N + 1];
        int start = 1, end = 1, sum = 1, answer = 1;
        for (int i = 1; i <= N; i++) {
            A[i] = i;
        }
        print(A);

        while (end < N) {
            if (sum < N) {
                sum += ++end;
            } else if (sum > N) {
                sum -= start++;
            } else{
                sum += end;
                answer++;
            }
        }

        System.out.println("answer = " + answer);
    }

}
