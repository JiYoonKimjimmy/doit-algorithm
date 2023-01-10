package chapter03;

import util.PrintUtil;

/**
 * 문제 000. 구간 합 구하기 2
 * N X N 표의 구간 좌표별 구간 합 구하기
 * [Solution]
 * - 주어진 좌표를 구간 합 새로운 좌표 배열 생성
 * - 구간 합 새로운 좌표 공식 : D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]
 * - (x1, y1) ~ (x2, y2) 까지의 구간 합 공식 : D[x2][y2] - D[x2][y1-1] - D[x1-1][y2] + D[x1-1][y1-1]
 */
public class Question004 {

    public static void main(String[] args) {
        int[][] A = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 2, 3, 4},
            {0, 2, 3, 4, 5},
            {0, 3, 4, 5, 6},
            {0, 4, 5, 6, 7}
        };

        for (int[] a: A) {
            PrintUtil.print(a);
        }

        solution(A, new int[]{2, 2, 3, 4});
        solution(A, new int[]{3, 4, 3, 4});
        solution(A, new int[]{1, 1, 4, 4});
    }

    private static void solution(int[][] A, int[] coordinate) {
        int size = A.length;
        int[][] D = new int[size][size];

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];
            }
        }

        int x1 = coordinate[0];
        int y1 = coordinate[1];
        int x2 = coordinate[2];
        int y2 = coordinate[3];
        int answer = D[x2][y2] - D[x2][y1-1] - D[x1-1][y2] + D[x1-1][y1-1];
        System.out.println("answer = " + answer);
    }

}
