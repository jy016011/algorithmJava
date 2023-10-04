package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q1157_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char answer = '?';
        String s = br.readLine();
        s = s.toUpperCase();
        int max = -1;
        int[] charCounts = new int[26];
        for (int i = 0; i < s.length(); i++){
            charCounts[s.charAt(i) - 65] += 1;
        }
        for (int i = 0; i < charCounts.length; i++) {
            if (max < charCounts[i]) {
                answer = (char) (i + 65);
                max = charCounts[i];
            }
            else if (max == charCounts[i]) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
