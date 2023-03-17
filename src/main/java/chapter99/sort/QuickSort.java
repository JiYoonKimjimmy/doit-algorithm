package chapter99.sort;

import static util.PrintUtil.print;

/**
 * Quick Sort 연습
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
public class QuickSort {

    public static void main(String[] args) {
        System.out.println("Hello Quick sort");
        QuickSort quickSort = new QuickSort();
        int[] A = new int[]{5, 2, 7, 3, 4, 1, 6};
        print(A);

        quickSort.sort(A, 0, A.length - 1);

        System.out.print("result = ");
        print(A);
    }

    private void sort(int[] A, int start, int end) {
        if (start < end) {
            int pivot = partition(A, start, end);

            sort(A, start, pivot - 1);
            sort(A, pivot + 1, end);
        }
    }

    private int partition(int[] A, int start, int end) {
        int pivot = A[end];
        int index = start - 1;

        System.out.print("start = " + start);
        System.out.print(", end = " + end);
        System.out.println(", index = " + index);
        print(A);

        for (int i = start; i < end; i++) {
            if (A[i] < pivot) {
                index++;
                swap(A, index, i);
                print(A);
            }
        }

        print(A);
        swap(A, index + 1, end);

        return index + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
