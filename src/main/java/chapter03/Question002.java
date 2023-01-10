package chapter03;

/**
 * 문제 002. 평균 구하기
 * - 기말고사를 망친 세준이의 점수 조작
 * - 시험 점수 중 최댓값 : M
 * - 각 시험 점수 변환 공식 : X / M * 100
 * - 변환 공식으로 계산된 각 시험 점수의 평균 구하는 프로그램
 * [Solution]
 * - 변환 계산식을 한번에 정리하여 계산 처리
 * - R = (A / M * 100 + B / M * 100 + C / M * 100) / 3
 * - R = (A + B + C) / M * 100 / 3
 */
public class Question002 {

    public static void main(String[] args) {
        solution2(new int[]{40, 80, 60});
        solution2(new int[]{10, 20, 30});
        solution2(new int[]{1, 100, 100, 100});
        solution2(new int[]{1, 2, 4, 8, 16});
        solution2(new int[]{3, 10});
    }

    private static void solution(int[] scores) {
        double max = 0, sum = 0;
        for (int score : scores) {
            if (score > max) max = score;
        }

        for (int score : scores) {
            sum += ((double) score / max) * 100;
        }

        double avg = sum / scores.length;
        System.out.println("avg = " + avg);
    }

    private static void solution2(int[] scores) {
        double max = 0, sum = 0;
        for (int score : scores) {
            if (score > max) max = score;
            sum += score;
        }

        double avg = sum / max * 100 / scores.length;
        System.out.println("avg = " + avg);
    }

}
