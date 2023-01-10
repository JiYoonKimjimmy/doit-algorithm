package chapter03;

/**
 * 문제 001. 수자의 합 구하기
 * N 개의 숫자가 공백 없이 써 있다. 이 숫자를 모두 합해 출력하는 프로그램 작성하시오.
 * - 1 <= N <= 100
 * [Solution]
 * - 입력된 문자열의 char 배열로 변환하여 각 자릿수를 합산
 */
public class Question001 {

    public static void main(String[] args) {
        solution("1");
        solution("54321");
        solution("10987654321");
    }

    private static void solution(String N) {
        int answer = 0;
        for (char c : N.toCharArray()) {
            answer += Character.getNumericValue(c);
        }
        System.out.println("answer = " + answer);
    }

}
