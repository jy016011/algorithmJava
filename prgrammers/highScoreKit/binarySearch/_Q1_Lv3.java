package prgrammers.highScoreKit.binarySearch;

import java.util.Arrays;

/*
프로그래머스 코딩테스트 고득점 kit 이분탐색, 문제 1번: 입국 심사
 */
public class _Q1_Lv3 {
    public static void main(String[] args) {
        _Q1_Lv3 solved = new _Q1_Lv3();
        int n = 6;
        int[] times = {7, 10};
        // answer: 28
        System.out.println(solved.solution(6, times));
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long minTime = 1;
        long maxTime = (long) times[times.length - 1] * n;
        long answer = maxTime;
        while (minTime <= maxTime) {
            long midTime = (minTime + maxTime) / 2;
            long passed = 0;
            for (int time : times) {
                passed += midTime / time;
            }
            if (passed < n) {
                minTime = midTime + 1;
            } else {
                maxTime = midTime - 1;
                answer = Math.min(answer, midTime);
            }
        }
        return answer;
    }
}
