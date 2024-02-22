package prgrammers.highScoreKit.sort;

import java.util.Arrays;

/*
프로그래머스 코딩테스트 고득점 kit 정렬, 문제 1번: K번째 수
 */
public class _Q1_Lv1 {

    public static void main(String[] args) {
        _Q1_Lv1 solved = new _Q1_Lv1();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        // answer: [5, 6, 3]
        System.out.println(Arrays.toString(solved.solution(array, commands)));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for (int[] command : commands) {
            int[] subArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(subArray);
            answer[index++] = subArray[command[2] - 1];
        }
        return answer;
    }
}
