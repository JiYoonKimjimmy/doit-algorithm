package chapter03;

import java.util.Stack;

import static util.PrintUtil.print;

/**
 * 문제 011. 스택으로 오름차순 수열 만들기
 * 임의의 수열을 스택에 넣었다가 출력하는 방식으로 오름차순 수열을 출력할 수 있는지 확인하고,
 * 출력할 수 있다면 push 와 pop 연산을 어떤 순서로 수행해야 하는지를 알아내는 프로그램을 작성하시오.
 * [Solution]
 * - 스택 `Stack` 개념을 활용하여, 자연수를 1 씩 증가시키면서 입력으로 주어진 숫자와 비교하여 증가시킨 자연수를 스택에 추가하거나 빼는 방식으로 접근한다.
 * - 스택 연산 수행 방법
 *      1. 현재 수열 값 >= 자연수
 *          - 현재 수열 값이 주어진 자연수와 크거나 같다면, 자연수를 1씩 증가시키고, 자연수를 스택에 `push` 한 뒤, 마지막 1회만 다시 `pop` 한다.
 *      2. 현재 수열 값 < 자연수
 *          - 현재 수열 값이 주어진 자연수보다 작다면, `pop` 하여 스택에 있는 값을 꺼내고, 꺼낸 값이 현재 수열 값이 아니라면, `NO` 를 출력하고 문제를 종료한다.
 */
public class Question011 {

    public static void main(String[] args) {
        solution(new int[]{4, 3, 6, 8, 7, 5, 2, 1});
        solution(new int[]{1, 2, 5, 3, 4});
    }

    private static void solution(int[] A) {
        StringBuilder answer = new StringBuilder();
        boolean result = true;

        print(A);
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for (int value : A) {
            if (num <= value) {
                while (num <= value) {
                    stack.push(num++);
                    answer.append("+ ");
                }

                stack.pop();
                answer.append("- ");

            } else {
                int pop = stack.pop();
                if (pop > value) {
                    System.out.println("answer = NO");
                    result = false;
                    break;
                } else {
                    answer.append("- ");
                }
            }
        }

        if (result) System.out.println("answer = " + answer);
    }

}
