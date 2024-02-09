package prgrammers;

/*
    프로그래머스 PCCP 기출문제 1번: 붕대 감기
*/
public class _PCCP_1 {
    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        _PCCP_1 solved = new _PCCP_1();
        System.out.println(solved.solution(bandage, health, attacks)); // answer: 5
    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int time = 0;
        int count = 0;
        int answer = health;

        for (int[] attack : attacks) {
            int attackedTime = attack[0];
            count = attackedTime - time - 1;
            if (count >= t) {
                answer += ((count / t) * (x * t + y) + (count % t) * x);
            } else {
                answer += (count * x);
            }
            if (answer > health) {
                answer = health;
            }
            answer -= attack[1];
            time = attackedTime;
            if (answer <= 0) {
                return -1;
            }
        }

        return answer;
    }
}
