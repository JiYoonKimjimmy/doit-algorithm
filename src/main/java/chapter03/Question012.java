package chapter03;

import java.util.Stack;

import static util.PrintUtil.print;

/**
 * 문제 012. 오큰수 구하기
 * 주어진 수열에서 i 번째에 있는 수의 오큰수는 i 번째 수보다 오른쪽에 있으면서, 더 큰 수를 의미한다.
 * 주어진 수열의 오큰수를 순서대로 출력하는 프로그램을 작성하시오.
 * (오큰수가 없는 경우, '-1' 을 출력한다.)
 * [Solution]
 * - 문제 풀이 순서
 * 1. 스택이 채워져 있거나, A[index] > A[top] 인 경우, `pop` 한 인덱스를 이용하여 정답 수열에 오큰수를 저장한다.
 *     - `pop` 조건을 만족하는 동안 계속 반복한다.
 * 2. 현재 인덱스를 스택에 `push` 하고, 다음 인덱스로 넘어간다.
 * 3. 과정 1 ~ 2 번을 수열 길이만큼 반복하고, 스택에 남겨진 인덱스를 정답 수열에 `-1` 저장한다.
 */
public class Question012 {

    public static void main(String[] args) {
        solution(new int[]{3, 5, 2, 7});
        solution(new int[]{9, 5, 4, 8});
    }

    private static void solution(int[] A) {
        int[] answer = new int[A.length];
        print(A);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                    answer[stack.pop()] = A[i];
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        System.out.print("answer = ");
        print(answer);
    }

}
