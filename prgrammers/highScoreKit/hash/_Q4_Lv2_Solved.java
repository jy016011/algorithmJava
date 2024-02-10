package prgrammers.highScoreKit.hash;

import java.util.HashMap;
import java.util.Map;


/*
프로그래머스 코딩테스트 고득점 kit 해시, 문제 4번: 의상
passed 30 cases of 30 cases
solved by using mathematical thinking
 */
public class _Q4_Lv2_Solved {
    public static void main(String[] args) {
        _Q4_Lv2 solved = new _Q4_Lv2();
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        System.out.println(solved.solution(clothes)); // answer: 5
    }

    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] wear : clothes) {
            String category = wear[1];
            if (map.containsKey(category)) {
                map.put(category, map.get(category) + 1);
                continue;
            }
            map.put(category, 1);
        }

        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }

        return --answer;
    }
}
