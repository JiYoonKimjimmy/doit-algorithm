package chapter03;

/**
 * 문제 006. 연속된 자연수의 합 구하기
 * - 자연수 N 을 몇 개의 연속된 자연수의 합으로 구성할 수 있는지 가짓수를 구한다.
 * [Solution]
 * - 1 ~ N 까지의 배열을 `투 포인터` 를 활용하여 각 연속된 자연수의 합을 비교하고, count 를 한다.
 * - `sum > N` 인 경우, `sum = sum - start_index; start_index++`
 * - `sum < N` 인 경우, `sum = sum + end_index; end_index++`
 * - `sum == N` 인 경우, `sum = sum + end_index; end_index++; count++`
 * - 주의할 점으로, 자기 자신의 숫자도 연속된 자연수의 합의 가짓수에 포함된다.
 */
public class ReQuestion006 {

    public static void main(String[] args) {
        ReQuestion006 question = new ReQuestion006();
        question.solution();
    }

    private void solution() {
        int answer = 1, N = 15;
        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = i;
        }

        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();

        int start = 1, end = 1, sum = A[start];

        while (end != N) {
            if (sum > N) {
                sum -= A[start++];
            } else if (sum < N) {
                sum += A[++end];
            } else {
                sum += A[++end];
                answer++;
            }
        }

        System.out.println("answer = " + answer);
    }

}
