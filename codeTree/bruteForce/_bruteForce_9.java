package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _bruteForce_9 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String parentheses = bufferedReader.readLine();
        int cnt = 0;
        for (int i = 0; i < parentheses.length() - 2; i++) {
            if (parentheses.charAt(i) != '(' || parentheses.charAt(i + 1) != '(') {
                continue;
            }
            for (int j = i + 2; j < parentheses.length() - 1; j++) {
                if (parentheses.charAt(j) != ')' || parentheses.charAt(j + 1) != ')') {
                    continue;
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
