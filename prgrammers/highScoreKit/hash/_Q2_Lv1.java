package prgrammers.highScoreKit.hash;

import java.util.HashMap;
import java.util.Map;

/*
프로그래머스 코딩테스트 고득점 kit 해시, 문제 2번: 완주하지 못한 선수
 */
public class _Q2_Lv1 {
    public static void main(String[] args) {
        _Q2_Lv1 solved = new _Q2_Lv1();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solved.solution(participant, completion)); // answer: mislav
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
                continue;
            }
            map.put(name, 1);
        }

        for (String name : completion) {
            if (map.containsKey(name)) {
                map.put(name, map.get(name) - 1);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                answer = key;
            }
        }
        return answer;
    }
}
