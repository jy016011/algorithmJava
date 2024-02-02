package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        List<Integer>[] dp = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            dp[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            dp[i].add(1);
            for (int j = 0; j < i; j++) {
                // if(dp[j][0] == 2){

                // }
                if (a[i] > a[j]) {
                    dp[i].set(0, Math.max(dp[i].get(0), dp[j].get(0) + 1));
                    dp[i].add() = a[j];
                }
            }
        }
    }
}

