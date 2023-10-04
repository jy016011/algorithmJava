package beakjoon.implementation.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q2941_CroatiaAlphabet {
    public static void main(String[] args) throws IOException {
        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
            for (String alpha : croatia
            ) {
                s = s.replace(alpha, "*");
                }
        System.out.println(s.length());
    }
}