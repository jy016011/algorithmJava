package prgrammers.highScoreKit.hash;

import java.util.HashMap;
import java.util.Map;


/*
프로그래머스 코딩테스트 고득점 kit 해시, 문제 4번: 의상
passed 29 cases of 30 cases, 1 case time out
solved by using backTracking
 */
public class _Q4_Lv2 {
    public static void main(String[] args) {
        _Q4_Lv2 solved = new _Q4_Lv2();
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        System.out.println(solved.solution(clothes)); // answer: 5
    }

    Map<String, Integer> map; // key: category, value: num of clothes
    String[] keyArr;
    int result = 0;

    public int solution(String[][] clothes) {
        map = new HashMap<>();
        for (String[] wear : clothes) {
            String category = wear[1];
            String name = wear[0];
            if (map.containsKey(category)) {
                map.put(category, map.get(category) + 1);
                continue;
            }
            map.put(category, 1);
        }
        keyArr = map.keySet().toArray(new String[0]);
        for (int i = 1; i <= keyArr.length; i++) {
            backTracking(0, i, 0, 1);
        }
        return result;
    }

    private void backTracking(int depth, int limit, int start, int multi) {
        if (depth == limit) {
            result += multi;
            return;
        }
        for (int i = start; i < keyArr.length; i++) {
            multi *= map.get(keyArr[i]);
            backTracking(depth + 1, limit, i + 1, multi);
            multi /= map.get(keyArr[i]);
        }
    }
}
