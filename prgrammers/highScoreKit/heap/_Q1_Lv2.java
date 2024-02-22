package prgrammers.highScoreKit.heap;

import java.util.PriorityQueue;

/*
프로그래머스 코딩테스트 고득점 kit 힙, 문제 1번: 더 맵게
 */
public class _Q1_Lv2 {

    public static void main(String[] args) {
        _Q1_Lv2 solved = new _Q1_Lv2();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solved.solution(scoville, K)); // answer: 2
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }

        int answer = 0;

        while (!pq.isEmpty()) {
            int lowest = pq.poll();
            if (lowest >= K) {
                break;
            }
            if (pq.isEmpty()) {
                return -1;
            }
            int second = pq.poll();
            int newS = lowest + (second * 2);
            pq.offer(newS);
            answer++;
        }
        return answer;
    }
}
