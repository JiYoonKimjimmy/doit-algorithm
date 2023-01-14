package chapter03;

/**
 * 문제 009. DNA 비밀번호
 * {A, C, G, T} 가 각각 몇 번 이상 등장해야 비밀번호로 사용할 수 있는지, 순서대로 주어졌을 때 만들 수 있는 DNA 비밀번호의 종류의 수를 구하는 프로그램을 작성하시오.
 * - DNA 비밀번호 정의 : {A, C, G, T} 문자가 각각 주어진 수만큼 등장하는 비밀번호
 * - ex) {A: 1, C: 1, G: 1, T: 0} 일 때, "ACCT" 는 DNA 비밀번호가 될 수 없지만, "GCCA" 는 DNA 비밀번호가 가능하다.
 * [Solution]
 * - `슬라이딩 윈도우` 개념을 활용하여, 문자열을 정해진 길이만큼 탐색 이동하면서 조건에 맞는지 확인한다.
 */
public class Question009 {

    public static void main(String[] args) {
        solution("CCTGGATTG", 8, new int[]{2, 0, 1, 1});
        solution("GATA", 2, new int[]{1, 0, 0, 1});
    }

    private static int[] checkArr, myArr;
    private static int checkSum;

    private static void solution(String S, int N, int[] _checkArr) {
        System.out.println("S = " + S);
        int answer = 0;
        char[] A = S.toCharArray();
        checkArr = _checkArr;
        myArr = new int[checkArr.length];
        checkSum = 0;

        for (int check : checkArr) {
            if (check == 0) checkSum++;
        }

        for (int i = 0; i < N; i++) {
            add(A[i]);
        }

        for (int i = N; i < S.length(); i++) {
            int j = i - N;
            add(A[i]);
            remove(A[j]);
            if (checkSum == 4) answer++;
        }

        System.out.println("answer = " + answer);
    }

    private static void add(char c) {
        switch (c) {
            case 'A' -> add(0);
            case 'C' -> add(1);
            case 'G' -> add(2);
            case 'T' -> add(3);
        }
    }

    private static void add(int index) {
        myArr[index]++;
        if (myArr[index] >= checkArr[index]) {
            checkSum++;
        }
    }

    private static void remove(char c) {
        switch (c) {
            case 'A' -> remove(0);
            case 'C' -> remove(1);
            case 'G' -> remove(2);
            case 'T' -> remove(3);
        }
    }

    private static void remove(int index) {
        myArr[index]--;
        if (myArr[index] == checkArr[index]) {
            checkSum--;
        }
    }

}
