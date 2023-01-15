package chapter03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제 013. 카드게임
 * N 장의 숫자가 있는 카드 배열이 주어진 경우, 1)제일 위에 있는 카드를 버리고, 2)다음 카드를 제일 아래로 옮긴다.
 * 1 ~ 2 번의 순서를 반복하여 마지막 한 장의 카드가 남겨졌을 때의 숫자를 구하는 프로그램을 작성하시오.
 * [Solution]
 * - 큐 `Queue` 의 선입선출 개념을 활용하여 접근한다.
 * - 주어진 수의 배열을 큐에 담고, 정해진 순서대로 숫자를 옮긴다.
 */
public class Question013 {

    public static void main(String[] args) {
        solution(6);
        solution(4);
    }

    private static void solution(int N) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println("answer = " + queue.poll());
    }

}
