package beakjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889_startAndLink {
    static int n;
    static int[][] s;
    static int result = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(result);
    }
    public static void dfs(int depth, int a){
        if (depth == n / 2){
            diff();
            return;
        }
        for (int i = a; i < n; i++){
            if (!visited[i]){
                visited[i] = true;
                dfs(depth + 1, a + 1);
                visited[i] = false;
            }
        }
    }
    public static void diff(){
        int sSum = 0;
        int lSum = 0;
        for (int i = 0; i < n - 1 ; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]){
                    sSum += s[i][j];
                    sSum += s[j][i];
                }
                else if (!visited[i] && !visited[j]){
                    lSum += s[i][j];
                    lSum += s[j][i];
                }
            }
        }
        int sub = Math.abs(sSum - lSum);
        if(sub == 0){
            System.out.println(0);
            System.exit(0);
        }
        result = Math.min(result, sub);
    }
}
