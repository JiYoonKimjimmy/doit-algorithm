package chapter03;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 문제 010. 최솟값 찾기
 * N 개의 수 중에서 슬라이딩 윈도우 크기만큼 수 배열에서 최솟값을 출력하는 프로그램을 작성하시오.
 * [Solution]
 * - `슬라이딩 윈도우` 개념과 `Deque` 를 활용하여 문제 접근!
 * - 탐색 범위를 적절히 설정하고, 범위안에서 정렬 없이 비교하는 방식을 잘 살펴보자.
 */
public class Question010 {

    public static void main(String[] args) {
        solution(12, 3, new int[]{1, 5, 2, 3, 6, 2, 3, 7, 3, 5, 2, 6});
    }

    private static void solution(int N, int L, int[] A) {
        Deque<Node> myDeque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int now = A[i];

            while (!myDeque.isEmpty() && myDeque.getLast().value > now) {
                myDeque.removeLast();
            }

            myDeque.addLast(new Node(now, i));

            if (myDeque.getFirst().index <= i - L) {
                myDeque.removeFirst();
            }

            System.out.print(myDeque.getFirst().value + " ");
        }
    }

    static class Node {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

}
