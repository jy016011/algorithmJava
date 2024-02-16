package prgrammers.highScoreKit.sort;

import java.util.Arrays;

public class _Q2_Lv2 {

    public static void main(String[] args) {
        _Q2_Lv2 solved = new _Q2_Lv2();
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
            while (true) {
                if (s1.length() == s2.length()) {
                    return Integer.parseInt(s2) - Integer.parseInt(s1);
                }
                if (s2.length() > s1.length()) {
                    for (int i = 0; i < s1.length(); i++) {
                        int n1 = Character.getNumericValue(s1.charAt(i));
                        int n2 = Character.getNumericValue(s2.charAt(i));
                        if (n1 != n2) {
                            return n2 - n1;
                        }
                    }
                    s2 = s2.substring(s1.length());
                }

                if (s1.length() > s2.length()) {
                    for (int i = 0; i < s2.length(); i++) {
                        int n1 = Character.getNumericValue(s1.charAt(i));
                        int n2 = Character.getNumericValue(s2.charAt(i));
                        if (n1 != n2) {
                            return n2 - n1;
                        }
                    }
                    s1 = s1.substring(s2.length());
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}
