package prgrammers.highScoreKit.sort;

import java.util.Arrays;

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
