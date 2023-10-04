package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q10809_FindAlphbets_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        for (int i = 0; i < 26; i++) {
            int ascii = i + 97;
            char c = (char) ascii;
            sb.append(s.indexOf(c)).append(" ");
        }
        System.out.println(sb);
    }
}
