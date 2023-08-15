package chapter03;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 문제 009. DNA 비밀번호
 * - 특정 문자열의 제한된 길이만큼의 문자열이 각 문자별 갯수 포함 조건이 충족하는 문자열 가짓수를 구한다.
 * [Solution]
 * - 특정 문자열을 배열로 만들어, `슬라이딩 윈도우` 활용하여 제한된 길이만큼 문자열을 비교한다.
 * - 문자열을 비교할 때, `check_sum` 배열을 활용하여, 각 문자 포함 갯수를 기록한다.
 * - `check_sum` 배열과 실제 체크해야할 배열을 비교하여 조건 충족하는 경우, `count++` 한다.
 */
public class ReQuestion009 {

    public static void main(String[] args) {
        ReQuestion009 question = new ReQuestion009();
        question.solution();
    }

    private void solution() {
        int answer = 0;
        int N = 8;
        int[] check = { 2, 0, 1, 1 };   // A C G T 순서
        int[] check_sum = new int[4];
        String S = "CCTGGATTG";
        char[] C = S.toCharArray();

        for (int i = 0; i < C.length; i++) {
            add(C[i], check_sum);
            print(C[i] + " ADD : ", check_sum);
            if (i > N - 1) {
                // 어차피 하나씩 밀리면서, 맨 앞에 있는 문자를 제거하게 된다.
                remove(C[i - N], check_sum);
                print(C[i - N] + " REMOVE : ", check_sum);
            }
            answer += check(check_sum, check) ? 1 : 0;
        }

        System.out.println("answer = " + answer);
    }

    private void add(char c, int[] check_sum) {
        switch (c) {
            case 'A' -> check_sum[0]++;
            case 'C' -> check_sum[1]++;
            case 'G' -> check_sum[2]++;
            case 'T' -> check_sum[3]++;
        }
    }

    private void remove(char c, int[] check_sum) {
        switch (c) {
            case 'A' -> check_sum[0]--;
            case 'C' -> check_sum[1]--;
            case 'G' -> check_sum[2]--;
            case 'T' -> check_sum[3]--;
        }
    }

    private boolean check(int[] check_sum, int[] check) {
        int result = 0;
        for (int i = 0; i < check.length; i++) {
            result += (check_sum[i] >= check[i]) ? 1 : 0;
        }
        return result == 4;
    }

    private void print(String prefix, int[] arr) {
        System.out.println(prefix + String.join(" ", Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new)));
    }

}
