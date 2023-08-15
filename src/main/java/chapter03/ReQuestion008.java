package chapter03;

import java.util.Arrays;

/**
 * 문제 008. '좋은 수' 구하기
 * - 주어진 N 개의 수에서 다른 두개의 수의 합으로 표현되는 수를 `좋은 수` 라고, 가짓수를 구한다.
 * [Solution]
 * - `좋은 수 K` 를 비교하기 위해서 앞/뒤에서 `투 포인터` 를 활용하여 숫자를 비교한다.
 * - `A[i] + A[j] < K` 인 경우, `i++`
 * - `A[i] + A[j] > K` 인 경우, `j--`
 * - `A[i] + A[j] == K` 인 경우, `i++; j--; count++`
 * - 주의할 점으로, `좋은 수` 를 표현할 때는 자기 자신의 숫자는 제외한다.
 */
public class ReQuestion008 {

    public static void main(String[] args) {
        ReQuestion008 question = new ReQuestion008();
        question.solution();
    }

    private void solution() {
        int answer = 0;
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Arrays.sort(A);

        for (int K : A) {
            int start = 0, end = A.length - 1;
            while (start < end) {
                if (A[start] + A[end] == K) {
                    if (A[start] != K && A[end] != K) {
                        answer++;
                        break;
                    } else if (A[start] == K) {
                        start++;
                    } else if (A[end] == K) {
                        end--;
                    }
                } else if (A[start] + A[end] < K) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println("answer = " + answer);
    }

}
