package beakjoon.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q7570_G3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] children = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            children[Integer.parseInt(stringTokenizer.nextToken()) - 1] = i;
        }
        int cnt = 1;
        int max = 1;
        for (int i = 0; i < N - 1; i++) {
            if (children[i + 1] > children[i]) {
                cnt++;
                max = Math.max(cnt, max);
                continue;
            }
            cnt = 1;
        }
        System.out.println(N - max);
    }
}
