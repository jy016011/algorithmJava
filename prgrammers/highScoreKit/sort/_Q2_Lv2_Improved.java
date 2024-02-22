package prgrammers.highScoreKit.sort;

import java.util.Arrays;

/*
프로그래머스 코딩테스트 고득점 kit 정렬, 문제 2번: 가장 큰 수
used simplify algorithm
 */
public class _Q2_Lv2_Improved {
    public static void main(String[] args) {
        _Q2_Lv2_Improved solved = new _Q2_Lv2_Improved();
        int[] numbers = {979, 97, 978, 81, 818, 817};
        // answer: "9799797881881817"
        System.out.println(solved.solution(numbers).equals("9799797881881817"));
        numbers = new int[]{0, 0, 0};
        // answer: "0"
        System.out.println(solved.solution(numbers).equals("0"));
    }

    public String solution(int[] numbers) {
        Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, (i1, i2) -> {
            String s1 = Integer.toString(i1);
            String s2 = Integer.toString(i2);
            return -(s1 + s2).compareTo(s2 + s1);
        });
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}
