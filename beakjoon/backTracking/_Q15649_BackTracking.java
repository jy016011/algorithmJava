package beakjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q15649_BackTracking {
    static int n, m;
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        m = Integer.parseInt(st.nextToken());
        dfs();

    }
    public static void dfs(){
        if (sb.length() == (m*2)){
            System.out.println(sb);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]){
                visited[i] = true;
                sb.append(i).append(" ");
                dfs();
                sb = new StringBuilder(sb.substring(0,sb.length()-2));
                visited[i] = false;
            }
        }
    }
}
