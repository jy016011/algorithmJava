package beakjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q1439_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String digits = bufferedReader.readLine();
        int shiftCount = 0;
        for (int i = 1; i < digits.length(); i++) {
            char before = digits.charAt(i - 1);
            char current = digits.charAt(i);
            if (before != current){
                shiftCount++;
            }
        }
        int result;
        if (shiftCount % 2 == 0){
            result = shiftCount / 2;
        }
        else {
            result = shiftCount / 2 + 1;
        }
        System.out.println(result);
    }
}
