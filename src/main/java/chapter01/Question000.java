package chapter01;

/**
 * 문제 000. 수 정렬하기
 * - N 개의 수가 주어졌을 때 이를 오름차순 정렬하는 프로그램
 * - 1 <= N <= 1,000,000, 시간 제한 : 2초
 * - `2초` 이란 시간 제한 조건을 만족하기 위해서는 `2억` 번 이하의 연산 횟수로 문제를 해결해야 한다.
 * - 주어진 문제의 제한 조건을 확인하고, 어떤 알고리즘을 적용할지 판단하는 것이 중요하다.
 * - 연산 횟수 = 알고리즘 시간 복잡도 X 데이터 크기
 */
public class Question000 {

    public static void main(String[] args) {
        int[] A = {5, 5, 3, 4, 2, 1};
        solution(A);
    }

    private static void solution(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    int t = A[i];
                    A[i] = A[j];
                    A[j] = t;
                }

                if (A[i] == A[j]) {
                    A[j] = 0;
                }
            }
        }

        for (int i: A) {
            if (i > 0) {
                System.out.println(i + " ");
            }
        }
    }

}
