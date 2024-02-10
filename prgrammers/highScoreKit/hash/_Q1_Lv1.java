package prgrammers.highScoreKit.hash;

import java.util.HashSet;
import java.util.Set;

/*
프로그래머스 코딩테스트 고득점 kit 해시, 문제 1번: 폰켓몬
 */

public class _Q1_Lv1 {
    public static void main(String[] args) {
        _Q1_Lv1 phoneketmon = new _Q1_Lv1();
        System.out.println(phoneketmon.solution(new int[]{1, 2, 3, 3}));
    }

    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        return Math.min(set.size(), (nums.length / 2));
    }
}
