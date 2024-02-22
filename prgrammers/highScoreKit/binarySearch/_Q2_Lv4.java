package prgrammers.highScoreKit.binarySearch;

import java.util.Arrays;

/*
프로그래머스 코딩테스트 고득점 kit 이분탐색, 문제 2번: 징검 다리
 */
public class _Q2_Lv4 {
    public static void main(String[] args) {
        _Q2_Lv4 solved = new _Q2_Lv4();
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        // answer: 4
        System.out.println(solved.solution(distance, rocks, n));
    }

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int answer = 0;
        int[] subDistances = new int[rocks.length + 1];
        subDistances[0] = rocks[0];
        subDistances[rocks.length] = distance - rocks[rocks.length - 1];
        for (int i = 1; i < rocks.length; i++) {
            subDistances[i] = rocks[i] - rocks[i - 1];
        }

        int maxDistance = distance;
        int minDistance = 1;
        while (minDistance <= maxDistance) {
            int midDistance = (minDistance + maxDistance) / 2;
            int distanceSum = 0;
            int removedStone = 0;
            for (int subDistance : subDistances) {
                distanceSum += subDistance;
                if (distanceSum < midDistance) {
                    removedStone++;
                    continue;
                }
                distanceSum = 0;
            }
            if (removedStone > n) {
                maxDistance = midDistance - 1;
                continue;
            }
            minDistance = midDistance + 1;
            answer = Math.max(answer, midDistance);
        }
        return answer;
    }
}
