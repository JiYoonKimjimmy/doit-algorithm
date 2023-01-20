package chapter04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 문제 016. 버블 소트 프로그램 1
 * 주어진 수 N 배열에서 버블 Swap 이 정렬이 일어나지 않는 횟수를 구하는 프로그램을 구현하시오.
 * - 1 <= N <= 500,000
 * [Solution]
 * - N 의 최대 범위가 500,000 이므로 문제가 버블 정렬 관련 문제이지만, 버블 정렬보단 더 낮은 시간 복잡도의 알고리즘을 활용해야 한다.
 * - 버블 Swap 일어나지 않는 수를 찾기 위해서 다른 방식은, 데이터의 정렬 전 index 와 정렬 후 index 를 비교해 왼쪽으로 가장 많이 이동한 값을 찾는다.
 * - * 단순 정렬을 위해 Java 의 `sort()` 함수를 활용한다. (`sort()` 함수의 시간 복잡도는 O(NlogN) 이다.)
 * - [정렬 전 index - 정렬 후 index] 의 결과값 중 [최댓값]을 구하고, [최댓값 + 1] 한 결과값을 구한다.
 *   (Swap 이 일어나지 않는 반복문이 한 번 더 실행되기 때문에 [최댓값 + 1] 한다.)
 */
public class Question016 {

    public static void main(String[] args) {
        solution(new int[]{10, 1, 5, 2, 3});
    }

    private static void solution(int[] A) {
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            Data data = new Data(i, A[i]);
            list.add(data);
        }

        list.sort(Comparator.comparingInt(o -> o.value));

        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i).index - i) {
                max = list.get(i).index - i;
            }
        }

        System.out.println("answer = " + (max + 1));
    }

    static class Data {
        int index;
        int value;

        Data(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }

}
