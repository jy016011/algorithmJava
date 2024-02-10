package beakjoon.backTracking.oldFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q15650_BackTracking {
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dfs(1);
    }

    public static void dfs(int start) {
        if (sb.length() == m * 2) {
            System.out.println(sb);
            return;
        }
        for (int i = start; i <= n; i++) {
            sb.append(i).append(" ");
            dfs(i + 1);
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        }
    }
}
