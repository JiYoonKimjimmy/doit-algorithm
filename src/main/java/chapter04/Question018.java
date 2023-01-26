package chapter04;

/**
 * 문제 018. ATM 인출 시간 계산하기
 * 한 대의 ATM 기를 활용하여 1 ~ N 명의 사람들이 각 돈을 인출하는 시간이 P 분씩 걸린다고 할때, 총 돈을 인출하는 데 걸리는 시간을 구하는 프로그램을 작성하시오.
 * - 1 <= N <= 1,000
 * - 1 <= P <= 1,000
 * [Solution]
 * - 모든 사람이 가장 빠른 시간에 돈을 인출하는 방법을 그리디 방식으로 접근한다.
 * - ATM 기의 인출 시간이 가장 적게 걸리는 사람이 먼저 인출할 수 있도록 순서를 정하는 것이 그리디 방식이다.
 * - 삽입 정렬을 활용하여 인출 시간 기준으로 순서를 정렬한다.
 * [삽입 정렬 수행 과정] (삽입 정렬의 시간 복잡도 : O(N^2)
 * 1. 현재 index 데이터 값을 선택한다.
 * 2. 현재 선택한 데이터가 정렬된 데이터 범위에 삽입될 위치를 탐색한다.
 * 3. 삽입 위치부터 index 에 있는 위치까지 shift 연산을 수행한다.
 * 4. 삽입 위치에 현재 선택한 데이터를 삽입하고 index++ 연산을 수행한다.
 * 5. 전체 데이터의 크기만큼 index 가 커질 때까지 반복한다.
 */
public class Question018 {

    public static void main(String[] args) {
        solution(new int[]{3, 1, 4, 3, 2});
    }

    private static void solution(int[] A) {
        int[] S = new int[A.length];

        for (int i = 1; i < A.length; i++) {
            int index = i;
            int value = A[i];

            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    index = j + 1;
                    break;
                }
                if (j == 0) {
                    index = 0;
                }
            }

            for (int j = i; j > index; j--) {
                A[j] = A[j - 1];
            }

            A[index] = value;
        }

        int answer = A[0];

        S[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            S[i] = S[i - 1] + A[i];
            answer += S[i];
        }

        System.out.println("answer = " + answer);
    }

}
