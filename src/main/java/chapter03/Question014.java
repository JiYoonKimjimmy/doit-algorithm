package chapter03;

import java.util.PriorityQueue;

/**
 * 문제 014. `절댓갑 힙` 구현하기
 * `절댓값 힙`은 다음과 같은 연산을 지원하는 자료구조다.
 * 1) 배열에 정수 x(x != 0)을 넣는다.
 * 2) 배열에서 절댓값이 가장 작은 값을 출력한 후, 그 값을 베열에서 제거한다. 절댓값이 가자 작은 값이 여러 개일 경우에는 그 중 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
 * `절대값 힙`을 구현하는 프로그램을 작성하시오.
 * - x = 0 입력된 경우, 배열에서 가장 작은 절댓값을 가진 수를 출력하고, 배열에서 삭제한다.
 * [Solution]
 * - 우선순위 큐 `Priority Queue` 개념을 활용하여, 1)절댓값이 작은 순서, 2)절댓값이 같다면, 더 작은 순서 이 2가지 기준으로 정렬하여 큐를 생성한다.
 */
public class Question014 {

    public static void main(String[] args) {
        solution(new int[]{1, -1, 0, 0, 0, 1, 1, -1, -1, 2, -2, 0, 0, 0, 0, 0, 0, 0});
    }

    private static void solution(int[] A) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) {
                return o1 < o2 ? -1 : 1;
            } else {
                return abs1 < abs2 ? -1 : 1;
            }
        });

        for (int n : A) {
            if (n != 0) {
                queue.add(n);
            } else {
                if (queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            }
        }

        System.out.println("answer = " + answer);
    }

}
