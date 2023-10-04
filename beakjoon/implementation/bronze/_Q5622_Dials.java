package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q5622_Dials {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int time = 0;
        for (int i = 0; i < s.length(); i++) {
            int dial = 0;
            if ((int)s.charAt(i) <= 80)
                dial = (s.charAt(i) - 65) / 3 + 2;
            else if ((int)s.charAt(i) > 80 && (int)s.charAt(i) <= 83) {
                dial = (s.charAt(i) - 65) / 4 + 3;
            } else if ((int)s.charAt(i) > 83) {
                dial = (s.charAt(i) - 66) / 7 + 6;
            } else if ((int)s.charAt(i) > 86) {
                dial = ((int)s.charAt(i) -67) / 4 + 4;
            }
            time += dial + 1;
        }
        System.out.println(time);
    }
}
