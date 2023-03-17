package chapter04;

import static util.PrintUtil.print;

/**
 * 문제 020. 수 정렬하기 2
 * N 개의 수가 주어졌을 때, 이를 오름차순 정렬하는 프로그램을 작성하시오.
 * - 1 <= N <= 1,000,000
 * [Solution]
 * - N 의 최대 범위가 1,000,000 이므로 O(NlogN) 의 시간 복잡도 정렬 알고리즘인 `병합 정렬`을 활용한다.
 * [병합 정렬]
 * - 병합 정렬은 분할 정복 방식을 사용해 데이터를 분할하고, 분할한 집합을 정렬하며 합치는 알고리즘이다.
 * - 병합 정렬의 시간 복잡도는 O(NlogN) 이다.
 * [수행 과정]
 * 1. 전체 배열을 하나가 남을 때까지 계속 2개씩 나눈다.
 * 2. 하나가 남은 배열부터 정렬을 하면서 인접한 배열과 병합한다.
 */
public class Question020 {

    public static int[] A, tmp;

    public static void main(String[] args) {
        solution(new int[]{5, 4, 3, 2, 1});
    }

    private static void solution(int[] arr) {
        A = arr;
        tmp = new int[A.length];
        merge(0, A.length - 1);
        print(A);
    }

    private static void merge(int s, int e) {
        if (e - s < 1) return;

        int m = s + (e - s) / 2;

//        System.out.print("s = " + s);
//        System.out.print(", e = " + e);
//        System.out.println(", m = " + m);

        merge(s, m);
        merge(m + 1, e);

        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m + 1;

        while (index1 <= m && index2 <= e) {
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }

        while (index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }



    }

}
