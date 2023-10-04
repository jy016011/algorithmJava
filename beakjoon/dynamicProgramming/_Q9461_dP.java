package beakjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q9461_dP {
    static long[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n;
        p = new long[101];
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            p[n] = getSequence(n);
            sb.append(p[n]).append("\n");
        }
        System.out.println(sb);
    }
    public static long getSequence(int n){
        if (p[n] != 0)
            return p[n];
        if(n == 1 || n == 2 || n == 3)
            return 1;
        p[n] = getSequence(n - 2) + getSequence(n - 3);
        return p[n];
    }
}
