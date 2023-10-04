package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q2501_B3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = 0;
        int cnt = 0;
        for (int i = 1; i <= p; i++) {
            if (p % i == 0){
                cnt += 1;
                if (cnt == k)
                    result = i;
            }
        }
        System.out.println(result);
    }
}
