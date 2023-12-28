package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _bruteForce_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        int cnt = 0;
        for (int i = 0; i < string.length() - 1; i++) {
            char parenthesisOpen = string.charAt(i);
            if (parenthesisOpen != '(') {
                continue;
            }
            for (int j = i + 1; j < string.length(); j++) {
                char parenthesisClose = string.charAt(j);
                if (parenthesisClose != ')') {
                    continue;
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
