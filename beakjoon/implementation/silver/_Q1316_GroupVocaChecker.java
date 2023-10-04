package beakjoon.implementation.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q1316_GroupVocaChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int check = N;
        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            for (int j = 0; j < s.length()- 1; j++) {
                if (s.charAt(j) == s.charAt(j + 1))
                    continue;
                else if (isIn(s,s.charAt(j),j+1)) {
                    check -= 1;
                    break;
                }
            }
        }
        System.out.println(check);
    }
    public static boolean isIn(String s, char c, int idx){
        for (int i = idx; i < s.length(); i++) {
            if (s.charAt(i) == c)
                return true;
        }
        return false;
    }
}
