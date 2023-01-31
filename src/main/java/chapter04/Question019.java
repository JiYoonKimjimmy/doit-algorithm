package chapter04;

import static util.PrintUtil.print;

/**
 * 문제 019. K번째 수 구하기
 * 수 N개가 주어졌을 때, 오름차순 정렬하고, 앞에서부터 K 번째에 있는 수를 구하는 프로그램을 작성하시오.
 * - 1 <= N <= 5,000,000
 * [Solution]
 * - N 의 범위가 최대 5,000,000 이므로 `O(NlogN)` 의 시간 복잡도를 가진 정렬를 활용하는 것이 좋다.
 * - 퀵 정렬 알고리즘을 활용하여 정렬를 구현한다.
 * [퀵 정렬 수행 과정]
 * 1. 데이터를 분할하는 `pivot`을 설정한다.
 * 2. `pivot`을 기준으로 다음 a ~ e 과정을 거쳐 데이터를 2개의 집합으로 분리한다.
 *      a. `start` < `pivot` 인 경우, `start++` 한다.
 *      b. `end` > `pivot` 인 경우, `end--` 한다.
 *      c. `start`> `pivot` && `end` < `pivot` 인 경우, `start` <> `end` 를 swap 하고, `start++`, `end--` 한다.
 *      d. `start` 와 `end` 가 만날 때까지 a ~ c 를 반복한다.
 *      e. `start` 와 `end` 가 만나면, 만난 지점의 데이터와 `pivot` 데이터를 비교하여, `pivot` 이 크면 만난 지점의 오른쪽, 아니면 왼쪽에 `pivot` 데이터를 위치한다.
 * 3. 분리 집합에서 각각 다시 `pivot` 을 선정한다.
 * 4. 분리 집합이 1개 이하가 될 때까지 과정 1 ~ 3 을 반복한다.
 */
public class Question019 {

    public static void main(String[] args) {
        solution(new int[]{4, 1, 2, 3, 5}, 2);
    }

    private static void solution(int[] A, int K) {
        int N = A.length;
        sort(A, 0, N - 1, K);

        print(A);

        System.out.println("answer = " + A[K - 1]);
    }

    private static void sort(int[] A, int S, int E, int K) {
        if (S < E) {
            int pivot = partition(A, S, E);

            if (K == pivot) {
                return;
            } else if (K < pivot) {
                sort(A, S, pivot - 1, K);
            } else {
                sort(A, pivot + 1, E, K);
            }
        }
    }

    private static int partition(int[] A, int S, int E) {
        int M = (S + E) / 2;

        swap(A, S, M);

        int pivot = A[S];
        int i = S, j = E;

        while (i < j) {
            while (pivot < A[j]) {
                j--;
            }
            while (i < j && pivot >= A[i]) {
                i++;
            }
            swap(A, i, j);
        }

        A[S] = A[i];
        A[i] = pivot;
        return i;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
