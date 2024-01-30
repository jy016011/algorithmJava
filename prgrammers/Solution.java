package prgrammers;

class Solution {
    public static String solution(String s) {
        String[] strings = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String input : strings) {
            int number = Integer.parseInt(input);
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        return min + " " + max;
    }

    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
    }
}
